package com.example.judetesmainmenuxml.ui.liked

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.judetesmainmenuxml.R
import com.example.judetesmainmenuxml.data.Design
import com.example.judetesmainmenuxml.databinding.FragmentLikedBinding
import com.example.judetesmainmenuxml.ui.explore.ListDesignAdapter

class LikedFragment : Fragment() {

    private var _binding: FragmentLikedBinding? = null

    private val binding get() = _binding!!

    private val list = ArrayList<Design>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val likedViewModel = ViewModelProvider(this)[LikedViewModel::class.java]

        _binding = FragmentLikedBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.rvLiked.setHasFixedSize(true)
        list.addAll(getLikeDesign())
        showRecyclerList()

        return root
    }

    private fun getLikeDesign(): ArrayList<Design> {
        val dataName = resources.getStringArray(R.array.data_design)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listDesign = ArrayList<Design>()
        for (i in dataName.indices) {
            val design = Design(dataName[i], dataPhoto.getResourceId(i, -1), dataPrice[i])
            listDesign.add(design)
            //  tes data
            Log.d("Array", "$design")
        }

        return listDesign
    }

    private fun showRecyclerList() {
        val layoutManager = GridLayoutManager(requireActivity(), 2)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvLiked.layoutManager = layoutManager


        val listDesignAdapter = ListDesignAdapter(list)
        binding.rvLiked.adapter = listDesignAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}