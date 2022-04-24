package com.example.codescanner.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CodeScanEntity::class], version = AppDatabase.VERSION_DB)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val VERSION_DB = 1
    }

    abstract fun getCodeScan(): CodeScanDao
}