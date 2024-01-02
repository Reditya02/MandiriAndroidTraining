package com.example.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SavingModel(
    val savingName: String,
    val accountNumber: String,
    val image: Int
) : Parcelable
