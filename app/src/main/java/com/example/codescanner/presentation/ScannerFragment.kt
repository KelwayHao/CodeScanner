package com.example.codescanner.presentation

import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.example.codescanner.R
import com.example.codescanner.databinding.FragmentScannerBinding
import com.example.codescanner.domain.repository.CodeScanInteractor
import com.example.codescanner.presentation.listener.ClickListener
import com.example.codescanner.presentation.viewmodel.ScannerViewModel
import com.example.codescanner.utils.openFragment
import javax.inject.Inject

class ScannerFragment() : Fragment(R.layout.fragment_scanner) {

    @Inject
    lateinit var viewModel: ScannerViewModel
    private lateinit var codeScanner: CodeScanner

    companion object {
        const val TAG = "Scanner Fragment"
        fun newInstance() = ScannerFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        CodeScannerApplication.appComponent?.inject(this)
        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
        val activity = requireActivity()
        codeScanner = CodeScanner(activity, scannerView)
        codeScanner.decodeCallback = DecodeCallback { result ->
            activity.runOnUiThread {

                viewModel.createScan(
                    result.text,
                    Calendar.getInstance().firstDayOfWeek.toString(),
                    Calendar.getInstance().time.toString()
                )

                Toast.makeText(activity, result.text, Toast.LENGTH_LONG).show()

                requireActivity().openFragment(R.id.frameFragment, TableCodeFragment.newInstance(), TableCodeFragment.TAG)
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}