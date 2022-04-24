package com.example.codescanner.presentation.scanner

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.example.codescanner.R

class ScannerFragment() : Fragment(R.layout.fragment_scanner) {

    private lateinit var codeScanner: CodeScanner

    companion object {
        const val TAG = "Scanner Fragment"
        fun newInstance() = ScannerFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val scannerView = view.findViewById<CodeScannerView>(R.id.scanner_view)
        val activity = requireActivity()
        codeScanner = CodeScanner(activity, scannerView)
        Scanner().startScanner(codeScanner, scannerView, requireActivity())
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