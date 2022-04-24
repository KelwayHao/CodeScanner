package com.example.codescanner.domain.di

import com.example.codescanner.domain.interactor.CodeScanInteractor
import com.example.codescanner.domain.interactor.CodeScanInteractorImpl
import com.example.codescanner.domain.repository.CodeScanRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideCodeScanInteractor(
        codeScanRepository: CodeScanRepository
    ): CodeScanInteractor {
        return CodeScanInteractorImpl(codeScanRepository)
    }
}