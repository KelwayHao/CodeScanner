package com.example.codescanner.domain.di

import com.example.codescanner.domain.repository.CodeScanInteractor
import com.example.codescanner.domain.repository.CodeScanRepository
import com.example.codescanner.domain.repository.CodeScanRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideCodeScanInteractor(
        codeScanRepository: CodeScanRepository
    ) : CodeScanInteractor {
        return CodeScanRepositoryImpl(codeScanRepository)
    }
}