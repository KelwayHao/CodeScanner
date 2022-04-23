package com.example.codescanner.utils

import com.example.codescanner.data.room.CodeScanEntity
import com.example.codescanner.domain.models.CodeScan

fun CodeScanEntity.entityToCodeScan() =
    CodeScan(
        id, code, date, time
    )

fun CodeScan.codeScanToEntity() =
    CodeScanEntity(
        id, link, date, time
    )