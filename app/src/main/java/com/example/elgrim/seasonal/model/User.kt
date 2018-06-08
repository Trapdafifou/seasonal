package com.example.elgrim.seasonal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
        var id: Number,
        var last_name: String,
        var first_name: String,
        var email: String,
        var city: String = ""
) : Parcelable