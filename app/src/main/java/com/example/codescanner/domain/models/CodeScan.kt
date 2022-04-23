package com.example.codescanner.domain.models

data class CodeScan(
    var id: Long = 0,
    val link: String,
    val date: String,
    val time: String
) {
    init {
        id = link.hashCode() + time.hashCode().toLong()
    }
}