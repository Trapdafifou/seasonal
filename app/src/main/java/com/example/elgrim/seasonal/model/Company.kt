package com.example.elgrim.seasonal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Company(val id: Number,
              val name: String,
              val jobs: Array<Job>,
              val address: String
) : Parcelable