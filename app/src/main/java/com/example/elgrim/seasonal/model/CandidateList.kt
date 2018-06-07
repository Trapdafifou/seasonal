package com.example.elgrim.seasonal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CandidateList(val candidates: List<Candidate>) : Parcelable