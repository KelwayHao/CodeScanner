package com.example.codescanner.presentation

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.codescanner.R
import com.example.codescanner.databinding.ActivityMainBinding
import com.example.codescanner.presentation.listener.ClickListener
import com.example.codescanner.utils.openFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding<ActivityMainBinding>()

    private var click = object : ClickListener {
        override fun getCode(code: String) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        CodeScannerApplication.appComponent?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initView()
    }

    private fun initView() {
        openFragment(R.id.frameFragment, TableCodeFragment.newInstance(), TableCodeFragment.TAG)
        binding.floatingScanButton.setOnClickListener {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1)
            openFragment(R.id.frameFragment, ScannerFragment.newInstance(), ScannerFragment.TAG)
        }
    }
}