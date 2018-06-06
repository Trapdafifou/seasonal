package com.example.elgrim.seasonal.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

fun Parcel.writeDate(date: Date) {
    writeLong(date.time)
}

fun Parcel.readDate(): Date {
    val long = readLong()
    return Date(long)
}

class Candidate: User, Parcelable {
    lateinit var year_exp: Number
    lateinit var available_at: Date
    lateinit var job_name: String
    lateinit var profile_view_count: Number
    lateinit var wage_claim: Number
    lateinit var description: String
    lateinit var profile_picture_url: String

    constructor(id: Number, lastname: String, firstname: String, email: String, password: String, token: String, year_exp: Number, available_at: Date, job_name: String, profile_view_count: Number, wage_claim: Number, description: String, profile_picture_url: String) : super(id, lastname, firstname, email, password, token) {
        this.year_exp = year_exp
        this.available_at = available_at
        this.job_name = job_name
        this.profile_view_count = profile_view_count
        this.wage_claim = wage_claim
        this.description = description
        this.profile_picture_url = profile_picture_url
    }

    constructor(parcel: Parcel) : super(parcel) {
        year_exp = parcel.readInt()
        available_at = parcel.readDate()
        job_name = parcel.readString()
        profile_view_count = parcel.readInt()
        wage_claim = parcel.readInt()
        description = parcel.readString()
        profile_picture_url = parcel.readString()

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeInt(year_exp as Int)
        parcel.writeDate(available_at)
        parcel.writeString(job_name)
        parcel.writeInt(profile_view_count as Int)
        parcel.writeInt(wage_claim as Int)
        parcel.writeString(description)
        parcel.writeString(profile_picture_url)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Candidate> {
        override fun createFromParcel(parcel: Parcel): Candidate {
            return Candidate(parcel)
        }

        override fun newArray(size: Int): Array<Candidate?> {
            return arrayOfNulls(size)
        }
    }
}