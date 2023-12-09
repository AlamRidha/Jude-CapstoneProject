package com.example.judetesmainmenuxml.ui.explore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.judetesmainmenuxml.R
import com.example.judetesmainmenuxml.data.Design
import com.example.judetesmainmenuxml.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    private val list = ArrayList<Design>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val exploreViewModel = ViewModelProvider(this)[ExploreViewModel::class.java]
        // Inflate the layout for this fragment
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //  test button
        binding.fabNotifications.setOnClickListener {
            Toast.makeText(activity, "Tombol notifications ditekan", Toast.LENGTH_SHORT).show()
        }

        // searchbar settings
        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener { textView, actionId, event ->
//                searchBar.text = searchView.text
                val searchText = searchView.text.toString()
                searchView.hide()
//                Toast.makeText(activity, searchView.text, Toast.LENGTH_SHORT).show()
                Toast.makeText(activity, searchText, Toast.LENGTH_SHORT).show()
                false
            }
        }

        binding.rvProDesign.setHasFixedSize(true)

        list.addAll(getListDesign())
        showRecyclerList()
        return root
    }

    private fun getListDesign(): ArrayList<Design> {
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
//        binding.rvProDesign.layoutManager = LinearLayoutManager(requireActivity())
        val layoutManager = LinearLayoutManager(requireActivity())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.rvProDesign.layoutManager = layoutManager

        val listDesignAdapter = ListDesignAdapter(list)
        binding.rvProDesign.adapter = listDesignAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


// show recycle list dump code
//        binding.rvProDesign.layoutManager = LinearLayoutManager(requireActivity())
//        val layoutManager = LinearLayoutManager(requireActivity())
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        binding.rvProDesign.layoutManager = layoutManager
//        binding.rvProDesign.setHasFixedSize(true)
//        val listDesignAdapter = ListDesignAdapter(list)
//        binding.rvProDesign.adapter = listDesignAdapter