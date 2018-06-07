package com.example.elgrim.seasonal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Professional(
        val id: Number,
        val user: User,
        val company: Company
) : Parcelable