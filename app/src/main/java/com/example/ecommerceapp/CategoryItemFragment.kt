import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.ItemDetailFragment
import com.example.ecommerceapp.LoginFragment
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.FragmentCategoryItemBinding

class CategoryItemFragment : Fragment() {

    private var _binding: FragmentCategoryItemBinding? = null
    private val binding get() = _binding!!
    private lateinit var categoryItemAdapter: CategoryItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryItems = getCategoryItems() // Get category items from somewhere

        categoryItemAdapter = CategoryItemAdapter(categoryItems,
            onAddToCartClick = { categoryItem ->
                // Handle add to cart click
                categoryItem.isAddedToCart = true
                categoryItem.quantity = 1
                categoryItemAdapter.notifyDataSetChanged()
            },
            onItemClick = { categoryItem ->
                // Handle item click
                navigateToItemDetailFragment(categoryItem)
            })

        // Set up RecyclerView
        binding.categoryItemRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryItemAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getCategoryItems(): List<CategoryItemList> {
        return listOf(
            CategoryItemList(R.drawable.fruit, "Item 1", 4.5f, "Description of item 1", 10.99),
            CategoryItemList(R.drawable.vegetables, "Item 2", 3.8f, "Description of item 2", 8.99),
            CategoryItemList(R.drawable.dairy, "Item 3", 4.2f, "Description of item 3", 12.99)
        )
    }

    private fun navigateToItemDetailFragment(categoryItem: CategoryItemList) {
        val fragment = ItemDetailFragment()


        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
