package com.example.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NotificationModel(
    val title: String,
    val description: String,
    val time: String
) : Parcelable
