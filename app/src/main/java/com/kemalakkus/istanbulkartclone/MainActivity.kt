package com.kemalakkus.istanbulkartclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kemalakkus.istanbulkartclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNav.background=null
        binding.bottomNav.menu.getItem(2).isEnabled=false


        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.passwordFragment -> {
                    binding.bottomNav.visibility = View.GONE
                    binding.fabButton.visibility = View.GONE
                }

                else ->{
                    binding.bottomNav.visibility = View.VISIBLE
                    binding.fabButton.visibility = View.VISIBLE
                }
            }
        }
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.myCardsFragment -> {
                    navController.navigate(R.id.passwordFragment)
                    return@setOnItemSelectedListener false
                }
                R.id.homeFragment2 -> {
                    navController.navigate(R.id.homeFragment2)
                    return@setOnItemSelectedListener false
                }
                R.id.findFragment2 -> {
                    navController.navigate(R.id.findFragment2)
                    return@setOnItemSelectedListener false
                }
                R.id.transactionsFragment -> {
                    navController.navigate(R.id.transactionsFragment)
                    return@setOnItemSelectedListener false
                }

                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }


    }
}



