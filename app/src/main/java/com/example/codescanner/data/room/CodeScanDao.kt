package com.example.codescanner.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CodeScanDao {

    @Insert
    suspend fun saveCode(code: CodeScanEntity)

    @Query("SELECT * FROM code_scanner")
    fun getAllCode(): Flow<List<CodeScanEntity>>

}