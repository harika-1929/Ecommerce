package com.example.ecommerceapp

import android.os.Parcel
import android.os.Parcelable

data class ItemDetails(
    val title: String,
    val rating: Float,
    val description: String,
    val imageResId: Int,
    val price: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readFloat(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeFloat(rating)
        parcel.writeString(description)
        parcel.writeInt(imageResId)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemDetails> {
        override fun createFromParcel(parcel: Parcel): ItemDetails {
            return ItemDetails(parcel)
        }

        override fun newArray(size: Int): Array<ItemDetails?> {
            return arrayOfNulls(size)
        }
    }
}

