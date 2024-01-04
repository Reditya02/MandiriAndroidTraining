package com.example.mandiriapps.model

import com.example.mandiriapps.R

data class HisoryTransactionModel(
    val date: String,
    val titleTransaction: String,
    val balanceTransaction: String,
    val subtitleTransaction: String,
    val iconTransaction: Int,
    val statusTransaction: Int
)

enum class statusTransaction(val value: Int) {
    Berhasil(0),
    Gagal(1),
    Pending(2)
}
