package com.kemalakkus.istanbulkartclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kemalakkus.istanbulkartclone.R
import com.kemalakkus.istanbulkartclone.databinding.CardItemBinding

class CardItemAdapter(): RecyclerView.Adapter<CardItemAdapter.CardViewHolder>() {

    private val cardCodeList = listOf("1234567812345678","8765432187654321","3322116655447788")
    private val cardRemainderList = listOf("9,35 TL","2,42 TL","35,12 TL")
    private val photoList = arrayListOf<Int>(R.drawable.ik_dijital,R.drawable.ik_kirmizi,R.drawable.ik_sari)
    private val colorList = listOf(R.color.digital_card, R.color.red_card, R.color.yellow_card)



    class CardViewHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.binding.ikChoise.setImageResource(photoList[position])
        holder.binding.ikCode.text = cardCodeList[position]
        holder.binding.turkishLira.text = cardRemainderList[position]
        
        val color = ContextCompat.getColor(holder.itemView.context, colorList[position % 3])
        holder.binding.cdCardItem.setCardBackgroundColor(color)
    }

    override fun getItemCount(): Int {
        return 3
    }
}

