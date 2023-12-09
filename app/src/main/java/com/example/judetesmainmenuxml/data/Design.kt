package com.example.judetesmainmenuxml.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Design(
    val nama: String,
    val photo: Int,
    val price: String,
) : Parcelable