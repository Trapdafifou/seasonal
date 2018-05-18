package com.example.elgrim.seasonal.model

import android.os.Parcel
import android.os.Parcelable

class Entreprise() : Parcelable {
    lateinit var id: Number
    lateinit var name: String
    lateinit var jobs: Array<String>
    lateinit var address: String

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        jobs = parcel.createStringArray()
        address = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeStringArray(jobs)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Entreprise> {
        override fun createFromParcel(parcel: Parcel): Entreprise {
            return Entreprise(parcel)
        }

        override fun newArray(size: Int): Array<Entreprise?> {
            return arrayOfNulls(size)
        }
    }
}