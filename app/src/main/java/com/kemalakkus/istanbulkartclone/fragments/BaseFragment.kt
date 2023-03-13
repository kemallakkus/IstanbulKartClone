package com.kemalakkus.istanbulkartclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.kemalakkus.istanbulkartclone.R
import com.kemalakkus.istanbulkartclone.adapters.HomeItemAdapter
import com.kemalakkus.istanbulkartclone.databinding.FragmentBaseBinding

open class BaseFragment : Fragment(R.layout.fragment_base) {


    private lateinit var binding: FragmentBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBaseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRv()


    }

    private fun setupRv(){

        binding.rvBase.apply {
            layoutManager = GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
            adapter = HomeItemAdapter()
        }

    }

}