package com.example.baguiocityguide.repository

import com.example.baguiocityguide.model.Place
import com.example.baguiocityguide.model.PlaceCategory

class PlaceRepository {
    private val places = listOf(
        Place(
            id = 1,
            name = "Choco-late de Batirol",
            address = "Igorot Park, Camp John Hay",
            description = "Traditional Filipino hot chocolate serving authentic tablea chocolate drinks",
            rating = 4.5f, // Add rating
            latitude = 16.4023, // Add latitude
            longitude = 120.5960, // Add longitude
            category = PlaceCategory.COFFEE_SHOPS
        ),
        Place(
            id = 2,
            name = "Good Taste Restaurant",
            address = "Carino Street, Baguio City",
            description = "Famous for their affordable and generous servings of Filipino dishes",
            rating = 4.0f, // Add rating
            latitude = 16.4023, // Add latitude
            longitude = 120.5960, // Add longitude
            category = PlaceCategory.RESTAURANTS
        ),
        Place(
            id = 3,
            name = "Burnham Park",
            address = "Jose Abad Santos Drive",
            description = "Historic urban park with boat riding, bike rental, and gardens",
            rating = 4.3f, // Add rating
            latitude = 16.4023, // Add latitude
            longitude = 120.5960, // Add longitude
            category = PlaceCategory.PARKS
        )
    )

    fun getPlacesByCategory(category: PlaceCategory): List<Place> {
        return places.filter { it.category == category }
    }

    fun getPlaceById(id: Int): Place? {
        return places.find { it.id == id }
    }

    fun getAllPlaces(): List<Place> {
        return places
    }
}