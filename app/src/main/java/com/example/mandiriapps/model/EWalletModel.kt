package com.example.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EWalletModel(
    val name: String = "",
    val image: Int = 0,
    val balance: Double = 0.0,
    var isConnected: Boolean = false
) : Parcelable
