package com.example.ecommerceapp

import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerceapp.databinding.FragmentItemDetailBinding

class ItemDetailFragment : Fragment() {
    private lateinit var binding: FragmentItemDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
}