import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.databinding.CategoryItemListBinding

class CategoryItemAdapter(
    private val items: List<CategoryItemList>,
    private val onItemClick: (CategoryItemList) -> Unit,
    private val onAddToCartClick: (CategoryItemList) -> Unit
) : RecyclerView.Adapter<CategoryItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: CategoryItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryItemList) {
            with(binding) {
                ivImage.setImageResource(item.imageResId)
                txtTitle.text = item.title
                myRatingBar.rating = item.rating
                txtProductDescription.text = item.description
                txtPrice.text = "$${item.price}"
                btnAddToCart.setOnClickListener {
                    onAddToCartClick(item)
                }

                if (item.isAddedToCart) {
                    btnAddToCart.visibility = View.GONE
                    quantityLayout.visibility = View.VISIBLE

                    quantityTextView.text = item.quantity.toString()

                    plusButton.setOnClickListener {
                        item.quantity++
                        quantityTextView.text = item.quantity.toString()
                    }

                    minusButton.setOnClickListener {
                        if (item.quantity > 1) {
                            item.quantity--
                            quantityTextView.text = item.quantity.toString()
                        }
                    }
                } else {
                    btnAddToCart.visibility = View.VISIBLE
                    quantityLayout.visibility = View.GONE
                }
                btnAddToCart.setOnClickListener {
                    onAddToCartClick(item)
                }
                itemView.setOnClickListener { onItemClick(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CategoryItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
