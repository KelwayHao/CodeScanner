package com.example.codescanner.domain.repository

import com.example.codescanner.domain.models.CodeScan
import kotlinx.coroutines.flow.Flow

interface CodeScanInteractor {
    fun getCodeScan(): Flow<List<CodeScan>>

    suspend fun createCodeScan(
        code: String,
        date: String,
        time: String
    )
}