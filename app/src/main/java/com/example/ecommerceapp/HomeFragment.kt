package com.example.ecommerceapp

import CategoryItemFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), CategoryAdapter.OnItemClickListener{

    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryRecyclerView: RecyclerView = view.findViewById(R.id.categoryRV)
        categoryRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        categoryAdapter = CategoryAdapter(getCategories(),this)
        categoryRecyclerView.adapter = categoryAdapter
    }

    private fun getCategories(): List<CategoryList> {
        return listOf(
            CategoryList(R.drawable.fruit, "Fruits"),
            CategoryList( R.drawable.vegetables, "Vegetables"),
            CategoryList(R.drawable.dairy, "Dairy")

        )
    }

    override fun onItemClick(position: Int) {
        val fragment = CategoryItemFragment()

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }


}