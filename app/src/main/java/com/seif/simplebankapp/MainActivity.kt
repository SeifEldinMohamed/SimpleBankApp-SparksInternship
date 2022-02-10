package com.seif.simplebankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.seif.simplebankapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host)
        binding.bottomNavigationView.setupWithNavController(navController)
        val appBarCompatActivity = AppBarConfiguration(setOf(R.id.clientsFragment, R.id.transactionsFragment, R.id.aboutFragment))
        setupActionBarWithNavController(navController, appBarCompatActivity)

        navController.addOnDestinationChangedListener{_, destination, _ ->
            when(destination.id){
                R.id.clientInfoFragment -> hideBottomNav()
                R.id.clientsFragment -> showBottomNav()
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host)
        return navController.navigateUp() ||
                super.onSupportNavigateUp()
    }
    private fun showBottomNav() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
    private fun hideBottomNav() {
        binding.bottomNavigationView.visibility = View.GONE
    }
}