package com.example.people.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RewriteQueriesToDropUnusedColumns
import com.google.gson.annotations.SerializedName


@SuppressLint("ParcelCreator")
data class Person (


    @SerializedName("avatar") val avatar: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("email") val email: String,
    @SerializedName("favouriteColour") val favouriteColor: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("id") val id: String,
    @SerializedName("jobTitle") val jobTitle: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("phone") val phone: String

): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }
}

@Entity
@RewriteQueriesToDropUnusedColumns
data class PersonResponse(
    @PrimaryKey val personResponseId: Int = 1,
    val personResponse: List<People>
)
