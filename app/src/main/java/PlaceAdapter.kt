package com.example.baguiocityguide.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.baguiocityguide.databinding.ItemPlaceBinding
import com.example.baguiocityguide.model.Place

class PlaceAdapter(private val onClick: (Place) -> Unit) : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    private var places: List<Place> = listOf()

    fun submitList(newPlaces: List<Place>) {
        places = newPlaces
        notifyDataSetChanged() // or use DiffUtil for more efficiency
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place, onClick)
    }

    override fun getItemCount(): Int = places.size

    class PlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place, onClick: (Place) -> Unit) {
            binding.placeName.text = place.name
            binding.root.setOnClickListener { onClick(place) } // Pass the entire Place object
        }
    }
}