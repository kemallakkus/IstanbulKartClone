package com.kemalakkus.istanbulkartclone.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.kemalakkus.istanbulkartclone.R
import com.kemalakkus.istanbulkartclone.adapters.HomeViewpagerAdapter
import com.kemalakkus.istanbulkartclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val categoriesFragment = arrayListOf<Fragment>(
            TumuFragment(),
            KampanyalarFragment(),
            HaberlerFragment()
        )

        binding.viewpagerHome.isUserInputEnabled = false

        val homeViewPagerAdapter =
            HomeViewpagerAdapter(categoriesFragment,childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = homeViewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome){ tab, position ->
            when (position) {
                0 -> tab.text = "Tümü"
                1 -> tab.text = "Kampanyalar"
                2 -> tab.text = "Haberler"
            }
        }.attach()

        for (i in 0 until binding.tabLayout.getTabCount()) {
            val tab = (binding.tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(20, 0, 20, 0)
            tab.requestLayout()
        }

    }

}