package com.example.baguiocityguide.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val id: Int,
    val name: String,
    val address: String,
    val description: String,
    val rating: Float,
    val latitude: Double,
    val longitude: Double,
    val category: PlaceCategory
) : Parcelable

