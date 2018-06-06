package com.example.elgrim.seasonal.model

import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Job(
        var id: Number,
        var lastname: String,
        var firstname: String,
        var email: String
) : Parcelable