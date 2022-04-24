package com.example.codescanner.presentation.scanner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codescanner.domain.interactor.CodeScanInteractor
import com.example.codescanner.domain.models.CodeScan
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScannerViewModel @Inject constructor(
    private val interactor: CodeScanInteractor
) : ViewModel() {

    private val _codeScanner = MutableLiveData<List<CodeScan>>()
    val codeScanner: LiveData<List<CodeScan>> get() = _codeScanner

    fun createScan(
        link: String,
        date: String,
        time: String
    ) {
        viewModelScope.launch {
            interactor.createCodeScan(
                link,
                date,
                time
            )
        }
    }
}