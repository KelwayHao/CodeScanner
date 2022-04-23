package com.example.codescanner.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "code_scanner")
data class CodeScanEntity(
    @PrimaryKey
    var id: Long,
    @ColumnInfo(name = "link")
    val code: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "time")
    val time: String
)
