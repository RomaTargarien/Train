package com.example.train

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Serial : Serializable {

}

data class Parce(
    val id: Int,
    val image: String
    ): Parcelable
{
    constructor(parcel: Parcel) : this (
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(id)
        dest?.writeString(image)
    }

    companion object CREATOR : Parcelable.Creator<Parce> {
        override fun createFromParcel(parcel: Parcel): Parce {
            return Parce(parcel)
        }

        override fun newArray(size: Int): Array<Parce?> {
            return arrayOfNulls(size)
        }
    }
}