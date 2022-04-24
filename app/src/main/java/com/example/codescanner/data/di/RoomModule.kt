package com.example.codescanner.data.di

import android.content.Context
import androidx.room.Room
import com.example.codescanner.data.room.AppDatabase
import com.example.codescanner.data.room.CodeScanDao
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "code_scanner"
        ).build()
    }

    @Provides
    fun provideCodeScanDao(database: AppDatabase): CodeScanDao {
        return database.getCodeScan()
    }

}