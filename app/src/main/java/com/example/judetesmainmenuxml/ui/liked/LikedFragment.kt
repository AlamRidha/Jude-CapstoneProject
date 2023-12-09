package com.example.judetesmainmenuxml.ui.liked

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.judetesmainmenuxml.R
import com.example.judetesmainmenuxml.databinding.FragmentLikedBinding

class LikedFragment : Fragment() {

    private var _binding: FragmentLikedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val likedViewModel = ViewModelProvider(this)[LikedViewModel::class.java]

        _binding = FragmentLikedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvLiked
        likedViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}