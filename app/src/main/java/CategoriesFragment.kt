package com.example.baguiocityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.baguiocityguide.databinding.FragmentCategoriesBinding
import com.example.baguiocityguide.model.PlaceCategory

class CategoriesFragment : Fragment() {
    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.coffeeShopsCard.setOnClickListener {
            navigateToRecommendations(PlaceCategory.COFFEE_SHOPS)
        }
        binding.restaurantsCard.setOnClickListener {
            navigateToRecommendations(PlaceCategory.RESTAURANTS)
        }
        binding.kidFriendlyCard.setOnClickListener {
            navigateToRecommendations(PlaceCategory.KID_FRIENDLY)
        }
        binding.parksCard.setOnClickListener {
            navigateToRecommendations(PlaceCategory.PARKS)
        }
        binding.shoppingCard.setOnClickListener {
            navigateToRecommendations(PlaceCategory.SHOPPING_CENTERS)
        }
    }

    private fun navigateToRecommendations(category: PlaceCategory) {
        val action = CategoriesFragmentDirections.actionCategoriesFragmentToRecommendationFragment(category)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}