package com.example.baguiocityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baguiocityguide.databinding.FragmentPlacesBinding
import com.example.baguiocityguide.adapter.PlaceAdapter
import com.example.baguiocityguide.model.PlaceCategory

class PlacesFragment : Fragment() {
    private val viewModel: PlaceViewModel by viewModels()
    private val args: PlacesFragmentArgs by navArgs()
    private lateinit var placeAdapter: PlaceAdapter
    private var _binding: FragmentPlacesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPlacesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.loadPlacesByCategory(args.category)
        observePlaces()
    }

    private fun setupRecyclerView() {
        placeAdapter = PlaceAdapter { place ->
            findNavController().navigate(
                PlacesFragmentDirections.actionPlacesFragmentToPlaceDetailsFragment(place)
            )
        }
        binding.placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placeAdapter
        }
    }

    private fun observePlaces() {
        viewModel.places.observe(viewLifecycleOwner) { places ->
            placeAdapter.submitList(places)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}