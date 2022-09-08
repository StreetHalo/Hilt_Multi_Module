package ru.petshop.hilt_multi_module.model

import android.os.Parcel
import android.os.Parcelable

data class Coin(
    val changePercent24Hr: Double,
    val name: String,
    val id: String = "",
    val priceUsd: Double,
    val symbol: String,
    var isSaved: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(changePercent24Hr)
        parcel.writeString(name)
        parcel.writeString(id)
        parcel.writeDouble(priceUsd)
        parcel.writeString(symbol)
        parcel.writeByte(if (isSaved) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coin> {
        override fun createFromParcel(parcel: Parcel): Coin {
            return Coin(parcel)
        }

        override fun newArray(size: Int): Array<Coin?> {
            return arrayOfNulls(size)
        }
    }

}