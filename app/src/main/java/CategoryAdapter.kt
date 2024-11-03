package com.example.baguiocityguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baguiocityguide.model.PlaceCategory

class CategoryAdapter(
    private val categories: List<PlaceCategory>,
    private val onCategoryClick: (PlaceCategory) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val categoryName: TextView = view.findViewById(R.id.category_name)

        fun bind(category: PlaceCategory, onCategoryClick: (PlaceCategory) -> Unit) {
            categoryName.text = category.name.replace("_", " ")
            itemView.setOnClickListener { onCategoryClick(category) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position], onCategoryClick)
    }

    override fun getItemCount() = categories.size
}
