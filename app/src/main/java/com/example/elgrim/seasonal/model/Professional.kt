package com.example.elgrim.seasonal.model

import android.os.Parcel
import android.os.Parcelable

public class Professional: User, Parcelable {
    lateinit var entreprise_id: Number

    constructor(id: Number, lastname: String, firstname: String, email: String, password: String, token: String, entreprise_id: Number): super(id, lastname, firstname, email, password, token) {
        this.entreprise_id = entreprise_id
    }

    constructor(parcel: Parcel) : super(parcel) {
        entreprise_id = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)

        parcel.writeInt(entreprise_id as Int)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Professional> {
        override fun createFromParcel(parcel: Parcel): Professional {
            return Professional(parcel)
        }

        override fun newArray(size: Int): Array<Professional?> {
            return arrayOfNulls(size)
        }
    }
}