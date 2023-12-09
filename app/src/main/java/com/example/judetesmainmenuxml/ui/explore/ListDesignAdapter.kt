package com.example.judetesmainmenuxml.ui.explore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.judetesmainmenuxml.R
import com.example.judetesmainmenuxml.data.Design
import com.example.judetesmainmenuxml.databinding.ItemRowDesignBinding

class ListDesignAdapter(private val listDesign: ArrayList<Design>) :
    RecyclerView.Adapter<ListDesignAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val binding = ItemRowDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_design, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listDesign.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val (name, photo, price) = listDesign[position]
//        holder.tvName.text = name
//        holder.imgPhoto.setImageResource(photo)
//        holder.tvPrice.text = price
        val design = listDesign[position]
        holder.tvName.text = design.nama
        holder.imgPhoto.setImageResource(design.photo)
        holder.tvPrice.text = design.price
//        tes klik item
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu Memilih " + listDesign[holder.adapterPosition].nama, Toast.LENGTH_SHORT).show()
        }
//        tes klik icon
        holder.ivFavorite.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu Memilih " + listDesign[holder.adapterPosition].nama, Toast.LENGTH_SHORT).show()
            holder.ivFavorite.setImageResource(R.drawable.ic_favorite_24)
        }

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_juduldesign)
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_design1)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_price)
        val ivFavorite: ImageView = itemView.findViewById(R.id.iv_favorite)
    }
}