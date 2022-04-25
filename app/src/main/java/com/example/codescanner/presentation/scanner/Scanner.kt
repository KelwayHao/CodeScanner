package com.example.codescanner.presentation.scanner

import android.icu.util.Calendar
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.example.codescanner.R
import com.example.codescanner.presentation.table.TableCodeFragment
import com.example.codescanner.utils.convertToDate
import com.example.codescanner.utils.convertToTime
import com.example.codescanner.utils.openFragment

class Scanner {

    fun startScanner(
        codeScanner: CodeScanner,
        scannerView: CodeScannerView,
        activity: FragmentActivity,
        getCodeScan: (link: String, date: String, time: String) -> Unit
    ) {
        codeScanner.decodeCallback = DecodeCallback { result ->
            activity.runOnUiThread() {

                getCodeScan(
                    result.text,
                    Calendar.getInstance().time.convertToDate(),
                    Calendar.getInstance().time.convertToTime()
                )

                Toast.makeText(activity, result.text, Toast.LENGTH_LONG).show()

                activity.openFragment(
                    R.id.frameFragment,
                    TableCodeFragment.newInstance(),
                    TableCodeFragment.TAG
                )
            }
        }
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }
}