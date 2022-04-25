package com.example.codescanner.utils

import com.example.codescanner.data.room.CodeScanEntity
import com.example.codescanner.domain.models.CodeScan
import java.text.SimpleDateFormat
import java.util.*

fun CodeScanEntity.entityToCodeScan() =
    CodeScan(
        id, link, date, time
    )

fun CodeScan.codeScanToEntity() =
    CodeScanEntity(
        id, link, date, time
    )

fun Date.convertToDate(): String {
    return SimpleDateFormat(Constant.DATE_FORMAT, Locale.ENGLISH).format(this)
}

fun Date.convertToTime(): String {
    return SimpleDateFormat(Constant.TIME_FORMAT, Locale.ENGLISH).format(this)
}