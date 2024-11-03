package com.example.baguiocityguide.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Locale

@Parcelize
enum class PlaceCategory : Parcelable {
    COFFEE_SHOPS,
    RESTAURANTS,
    KID_FRIENDLY,
    PARKS,
    SHOPPING_CENTERS;

    override fun toString(): String {
        return name.replace('_', ' ').split(' ')
            .joinToString(" ") { word ->
                word.lowercase(Locale.getDefault())
                    .replaceFirstChar { char ->
                        char.uppercase(Locale.getDefault())
                    }
            }
    }
}