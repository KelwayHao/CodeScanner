package com.example.codescanner.domain.repository

import com.example.codescanner.data.room.CodeScanEntity
import com.example.codescanner.domain.models.CodeScan
import kotlinx.coroutines.flow.Flow

interface CodeScanRepository {
    fun getSavedCodeScan(): Flow<List<CodeScanEntity>>

    suspend fun saveCodeScan(codeScan: CodeScan)

}