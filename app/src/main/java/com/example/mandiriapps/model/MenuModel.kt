package com.example.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MenuModel(
    val image: Int,
    val menuTitle: String
) : Parcelable
