package com.example.elgrim.seasonal.model

import android.os.Parcel
import android.os.Parcelable

open class User() : Parcelable {
    lateinit var id : Number
    lateinit var lastname: String
    lateinit var firstname: String
    lateinit var email: String
    lateinit var password: String

    constructor(parcel: Parcel) : this() {
        lastname = parcel.readString()
        firstname = parcel.readString()
        email = parcel.readString()
        password = parcel.readString()
    }


    constructor(id: Number, lastname: String, firstname: String, email: String, password: String) : this() {
        this.id = id
        this.lastname = lastname
        this.firstname = firstname
        this.email = email
        this.password = password
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(lastname)
        parcel.writeString(firstname)
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}