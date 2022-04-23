package com.example.codescanner.data.di

import com.example.codescanner.data.repository.CodeScanEntityRepositoryImpl
import com.example.codescanner.data.room.CodeScanDao
import com.example.codescanner.domain.repository.CodeScanRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCodeScanRepository(
        codeScanDao: CodeScanDao
    ) : CodeScanRepository {
        return CodeScanEntityRepositoryImpl(codeScanDao)
    }
}