package com.example.kotlinwithjetpack.gaadi.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@Entity(tableName = "gaadi", indices = [Index(value = ["name", "sellerDetails"], unique = true)])
data class Gaadi(@PrimaryKey(autoGenerate = true)
                 @field:SerializedName("id")
                 val id: Int,
                 @field:SerializedName("name")
                 val name: String,
                 @field:SerializedName("seller_details")
                 val sellerDetails: String,
                 @field:SerializedName("gaadi_details")
                 val gaadiDetails: String,
                 @field:SerializedName("images")
                 val images: List<String>) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(sellerDetails)
        parcel.writeString(gaadiDetails)
        parcel.writeStringList(images)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Gaadi> {
        override fun createFromParcel(parcel: Parcel): Gaadi {
            return Gaadi(parcel)
        }

        override fun newArray(size: Int): Array<Gaadi?> {
            return arrayOfNulls(size)
        }
    }

}