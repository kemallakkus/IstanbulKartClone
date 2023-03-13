package com.kemalakkus.istanbulkartclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kemalakkus.istanbulkartclone.R
import com.kemalakkus.istanbulkartclone.adapters.CardItemAdapter
import com.kemalakkus.istanbulkartclone.adapters.HomeItemAdapter
import com.kemalakkus.istanbulkartclone.databinding.CardItemBinding
import com.kemalakkus.istanbulkartclone.databinding.FragmentMyCardsBinding

class MyCardsFragment : Fragment(R.layout.fragment_my_cards) {


    private lateinit var binding: FragmentMyCardsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyCardsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRv()

    }

    private fun setupRv(){

        binding.rvMyCards.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = CardItemAdapter()
        }

    }


}