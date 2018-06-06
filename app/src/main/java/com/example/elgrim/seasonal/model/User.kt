package com.example.elgrim.seasonal.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
        var id: Number,
        var lastname: String,
        var firstname: String,
        var email: String
) : Parcelable