package com.example.codescanner.domain.interactor

import com.example.codescanner.domain.models.CodeScan
import com.example.codescanner.domain.repository.CodeScanRepository
import com.example.codescanner.utils.entityToCodeScan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CodeScanInteractorImpl(private val codeScanRepository: CodeScanRepository) :
    CodeScanInteractor {

    override fun getCodeScan(): Flow<List<CodeScan>> {
        return codeScanRepository.getSavedCodeScan().map { list ->
            list.map { codeScanEntity ->
                codeScanEntity.entityToCodeScan()
            }
        }
    }

    override suspend fun createCodeScan(link: String, date: String, time: String) {
        codeScanRepository.saveCodeScan(
            CodeScan(
                link = link,
                date = date,
                time = time
            )
        )
    }
}