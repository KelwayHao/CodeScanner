package com.example.codescanner.domain.repository

import com.example.codescanner.domain.models.CodeScan
import com.example.codescanner.utils.entityToCodeScan
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class CodeScanRepositoryImpl(private val codeScanRepository: CodeScanRepository) :
    CodeScanInteractor {

    override fun getCodeScan(): Flow<List<CodeScan>> {
        return flow {
            while (true){
                codeScanRepository.getSavedCodeScan().map { list ->
                    emit(list.map { codeScanEntity ->
                        codeScanEntity.entityToCodeScan()
                    })
                }
                delay(3000L)
            }
        }.distinctUntilChanged()
            .flowOn(Dispatchers.IO)
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