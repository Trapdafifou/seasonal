package com.example.elgrim.seasonal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Candidate(
        val user: User,
        val year_exp: Int,
        val available_at: String,
        val profile_view_count: Int,
        val wage_claim: Int,
        val profile_picture: String? = null,
        val description: String,
        val job: Job,
        val job_id: Int
) : Parcelable