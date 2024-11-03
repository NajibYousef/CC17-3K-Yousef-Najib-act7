package com.example.baguiocityguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.baguiocityguide.databinding.FragmentRecommendationBinding
import com.example.baguiocityguide.model.PlaceCategory

class RecommendationFragment : Fragment() {
    private var _binding: FragmentRecommendationBinding? = null
    private val binding get() = _binding!!
    private val args: RecommendationFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRecommendationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
        displayRecommendations()
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = args.category.name.replace("_", " ")
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    private fun displayRecommendations() {
        when (args.category) {
            PlaceCategory.COFFEE_SHOPS -> displayCoffeeShops()
            PlaceCategory.RESTAURANTS -> displayRestaurants()
            PlaceCategory.KID_FRIENDLY -> displayKidFriendlyPlaces()
            PlaceCategory.PARKS -> displayParks()
            PlaceCategory.SHOPPING_CENTERS -> displayShoppingCenters()
        }
    }

    private fun displayCoffeeShops() {
        binding.textViewRecommendations.text = """
            1. Choco-late de Batirol - Known for its warm, handcrafted hot chocolate.
            2. Cafe by the Ruins - Offers coffee and dishes inspired by local produce.
            3. Tsokolateria Artisanal Cafe - A paradise for chocolate lovers.
            4. Arca's Yard - A cafe and museum with excellent views.
        """.trimIndent()
    }

    private fun displayRestaurants() {
        binding.textViewRecommendations.text = """
            1. Good Taste - Generous servings of Filipino dishes.
            2. Hill Station - Fusion cuisine in a historic setting.
            3. Oh My Gulay - Vegetarian cafe with unique interiors.
            4. Vizco’s Restaurant and Cake Shop - Known for its Strawberry Shortcake.
            5. Secret Garden - Cozy ambiance with Italian-inspired dishes.
        """.trimIndent()
    }

    private fun displayKidFriendlyPlaces() {
        binding.textViewRecommendations.text = """
            1. Burnham Park - Family favorite with boat rides and picnic areas.
            2. Botanical Garden - Nature trails and mini waterfalls for kids.
            3. Baguio Orchidarium - A beautiful space for flower lovers.
            4. Mines View Park - Scenic views and traditional Igorot attire.
            5. Baguio Night Market - Explore local goods and street food.
        """.trimIndent()
    }

    private fun displayParks() {
        binding.textViewRecommendations.text = """
            1. Wright Park - Known for horseback riding and beautiful pines.
            2. Camp John Hay - Offers open spaces and scenic trails.
            3. Burnham Park - Lake, rose garden, and skating rink.
            4. Botanical Garden - Themed gardens and peaceful retreats.
            5. The Mansion Grounds - Historic grounds with stunning views.
        """.trimIndent()
    }

    private fun displayShoppingCenters() {
        binding.textViewRecommendations.text = """
            1. SM City Baguio - The largest mall with a fantastic view.
            2. Baguio Night Market - Local crafts and street food.
            3. Porta Vaga Mall - Local boutiques and shops.
            4. Maharlika Livelihood Complex - Souvenir shops and handicrafts.
            5. Hill Station at Casa Vallejo - Artisanal goods and local crafts.
        """.trimIndent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
