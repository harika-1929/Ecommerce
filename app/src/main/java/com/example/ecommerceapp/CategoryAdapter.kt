package com.example.ecommerceapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val categories: List<CategoryList>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = categories[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = categories.size

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val textViewTitle: TextView = itemView.findViewById(R.id.txtPhTitle)
        private val imageViewIcon: ImageView = itemView.findViewById(R.id.imgImage)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(category: CategoryList) {
            textViewTitle.text = category.categoryTitle
            imageViewIcon.setImageResource(category.imgId)
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}