package com.example.baguiocityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.baguiocityguide.databinding.FragmentPlaceDetailsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.appcompat.app.AppCompatActivity

class PlaceDetailsFragment : Fragment(), OnMapReadyCallback {
    private var _binding: FragmentPlaceDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: PlaceDetailsFragmentArgs by navArgs()
    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaceDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupMapFragment()
        displayPlaceDetails()
        setupFabListener()
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.detailToolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    private fun setupMapFragment() {
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun displayPlaceDetails() {
        args.place?.let { place ->
            binding.placeName.text = place.name
            binding.placeAddress.text = place.address
            binding.placeDescription.text = place.description
            binding.ratingBar.rating = place.rating
        } ?: run {
            binding.placeName.text = "Unknown Place"
        }
    }

    private fun setupFabListener() {
        binding.fabDirections.setOnClickListener {
            // Handle directions button click
            args.place?.let { place ->
                // Launch Google Maps or navigation intent
            }
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        args.place?.let { place ->
            val location = LatLng(place.latitude, place.longitude)
            googleMap.addMarker(
                MarkerOptions()
                    .position(location)
                    .title(place.name)
            )
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}