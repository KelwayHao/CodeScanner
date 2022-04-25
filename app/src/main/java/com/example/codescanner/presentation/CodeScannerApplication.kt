package com.example.codescanner.presentation

import android.app.Application
import com.example.codescanner.AppComponent
import com.example.codescanner.DaggerAppComponent

class CodeScannerApplication : Application() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .buildContext(this)
            .build()
    }
}