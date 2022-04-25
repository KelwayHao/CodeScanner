package com.example.codescanner.presentation.scanner

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.budiyev.android.codescanner.CodeScanner
import com.example.codescanner.R
import com.example.codescanner.databinding.FragmentScannerBinding
import javax.inject.Inject

class ScannerFragment() : Fragment(R.layout.fragment_scanner) {

    @Inject
    lateinit var viewModel: ScannerViewModel
    private val binding by viewBinding<FragmentScannerBinding>()
    private lateinit var codeScanner: CodeScanner

    companion object {
        const val TAG = "Scanner Fragment"
        fun newInstance() = ScannerFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val scannerView = binding.scannerView
        val activity = requireActivity()
        codeScanner = CodeScanner(activity, scannerView)
        Scanner().startScanner(codeScanner, scannerView, requireActivity()) { link, date, time ->
            viewModel.createScan(link, date, time)
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