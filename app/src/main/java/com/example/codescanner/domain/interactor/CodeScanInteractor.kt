package com.example.codescanner.domain.interactor

import com.example.codescanner.domain.models.CodeScan
import kotlinx.coroutines.flow.Flow

interface CodeScanInteractor {
    fun getCodeScan(): Flow<List<CodeScan>>

    suspend fun createCodeScan(
        link: String,
        date: String,
        time: String
    )
}