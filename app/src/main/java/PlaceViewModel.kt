package com.example.baguiocityguide

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baguiocityguide.model.Place
import com.example.baguiocityguide.model.PlaceCategory
import com.example.baguiocityguide.repository.PlaceRepository

class PlaceViewModel : ViewModel() {
    private val repository = PlaceRepository() // Instantiate the repository
    private val _places = MutableLiveData<List<Place>>()
    val places: LiveData<List<Place>> = _places

    fun loadPlacesByCategory(category: PlaceCategory) {
        // Use the repository to get places by category
        _places.value = repository.getPlacesByCategory(category)
    }

    fun loadAllPlaces() {
        // Optional: Load all places if needed
        _places.value = repository.getAllPlaces()
    }

    fun getPlaceById(id: Int): Place? {
        return repository.getPlaceById(id)
    }
}