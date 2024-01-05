package com.example.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryTransactionModel(
    val date: String,
    val titleTransaction: String,
    val balanceTransaction: String,
    val subtitleTransaction: String,
    val iconTransaction: Int,
    val statusTransaction: Int
) : Parcelable

enum class StatusTransaction(val value: Int) {
    Berhasil(0),
    Gagal(1),
    Pending(2)
}
