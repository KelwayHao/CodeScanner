package com.example.codescanner.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codescanner.domain.models.CodeScan
import com.example.codescanner.domain.repository.CodeScanInteractor
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TableCodeViewModel @Inject constructor(
    private val interactor: CodeScanInteractor
) : ViewModel() {

    private val _codeScanner = MutableLiveData<List<CodeScan>>()
    val codeScanner: LiveData<List<CodeScan>> get() = _codeScanner

    init {
        initFlow()
    }

    private fun initFlow() {
        interactor.getCodeScan()
            .map { _codeScanner.postValue(it) }
            .launchIn(viewModelScope)
    }
}