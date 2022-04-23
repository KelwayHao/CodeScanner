package com.example.codescanner.data.repository

import com.example.codescanner.data.room.CodeScanDao
import com.example.codescanner.data.room.CodeScanEntity
import com.example.codescanner.domain.models.CodeScan
import com.example.codescanner.domain.repository.CodeScanRepository
import com.example.codescanner.utils.codeScanToEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CodeScanEntityRepositoryImpl(
    private val codeScanDao: CodeScanDao
) : CodeScanRepository {
    override fun getSavedCodeScan(): Flow<List<CodeScanEntity>> {
        return codeScanDao.getAllCode()
    }

    override suspend fun saveCodeScan(codeScan: CodeScan) {
        return withContext(Dispatchers.IO) {
            codeScanDao.saveCode(codeScan.codeScanToEntity())
        }
    }
}

/*
flow {
            while (true){
                emit<List<CodeScan>>(
                    codeScanDao.getAllCode().map { list ->
                        list.map { codeScanEntity ->
                            codeScanEntity.entityToCodeScan()
                        }
                    }
                )
                delay(3000L)
            }
        }.flowOn(Dispatchers.IO)*/