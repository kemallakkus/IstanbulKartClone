package com.kemalakkus.istanbulkartclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kemalakkus.istanbulkartclone.R
import com.kemalakkus.istanbulkartclone.databinding.HomeItemBinding

class HomeItemAdapter(): RecyclerView.Adapter<HomeItemAdapter.HomeItemAdapterViewHolder>() {

    inner class HomeItemAdapterViewHolder(val binding: HomeItemBinding): RecyclerView.ViewHolder(binding.root)
    val photoList = arrayListOf<Int>(R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,R.drawable.photo4)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemAdapterViewHolder {
        val view = HomeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeItemAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeItemAdapterViewHolder, position: Int) {
        holder.binding.cvHome.setImageResource(photoList[position])

    }

    override fun getItemCount(): Int {
        return 10
    }
}