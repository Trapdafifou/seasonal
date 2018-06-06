package com.example.elgrim.seasonal.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

// https://proandroiddev.com/parcelable-in-kotlin-here-comes-parcelize-b998d5a5fcac
@Parcelize
@JsonClass(generateAdapter = true)
data class Candidate(
        var id: Int,
        @Json(name = "user") var user: User,
        var year_exp: Number,
        var available_at: Date,
        var job_name: String,
        var profile_view_count: Int,
        var wage_claim: Int,
        var description: String,
        var profile_picture: String,
        @Json(name = "job") var job: Job
) : Parcelable