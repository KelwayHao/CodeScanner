package com.example.codescanner

import android.content.Context
import com.example.codescanner.data.di.DataModule
import com.example.codescanner.data.di.RoomModule
import com.example.codescanner.domain.di.DomainModule
import com.example.codescanner.presentation.MainActivity
import com.example.codescanner.presentation.ScannerFragment
import com.example.codescanner.presentation.TableCodeFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [DataModule::class, RoomModule::class, DomainModule::class]
)
interface AppComponent {
    fun inject(target: MainActivity)
    fun inject(target: ScannerFragment)
    fun inject(target: TableCodeFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context) : Builder
        fun build(): AppComponent
    }
}