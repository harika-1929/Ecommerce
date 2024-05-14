import android.os.Parcel
import android.os.Parcelable

data class CategoryItemList(
    val imageResId: Int,
    val title: String,
    val rating: Float,
    val description: String,
    val price: Double,
    var isAddedToCart: Boolean = false,
    var quantity: Int = 1
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readFloat(),
        parcel.readString() ?: "",
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(title)
        parcel.writeFloat(rating)
        parcel.writeString(description)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CategoryItemList> {
        override fun createFromParcel(parcel: Parcel): CategoryItemList {
            return CategoryItemList(parcel)
        }

        override fun newArray(size: Int): Array<CategoryItemList?> {
            return arrayOfNulls(size)
        }
    }
}
