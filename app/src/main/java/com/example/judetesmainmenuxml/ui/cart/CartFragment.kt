package com.example.judetesmainmenuxml.ui.cart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.judetesmainmenuxml.R
import com.example.judetesmainmenuxml.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cartViewModel = ViewModelProvider(this)[CartViewModel::class.java]
        // Inflate the layout for this fragment
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.ibPlus.setOnClickListener {
            Log.d("Button", "Button Tambah ditekan")
        }

        binding.ibMinus.setOnClickListener {
            Log.d("Button", "Button Minus ditekan")
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}