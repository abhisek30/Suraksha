package com.asity.tech.suraksha

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.asity.tech.suraksha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.mapsFragment,
                R.id.notificationFragment,
                R.id.accountsFragment
            )
        )
        //setupActionBarWithNavController(navHostFragment,appBarConfiguration)
        //setupActionBarWithNavController(navController)

        bottomNavigationView.setupWithNavController(navController)
        bottomNavigationView.itemIconTintList = null


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.permissionFragment) {

                bottomNavigationView.visibility = View.GONE
                binding.appBarLayout.visibility = View.GONE
            } else {
                binding.appBarLayout.visibility = View.VISIBLE
                bottomNavigationView.visibility = View.VISIBLE
            }
        }
        /*bottomNavigationView.setOnItemSelectedListener { item->
            lateinit var fragment : Fragment
            when(item.itemId){
                R.id.homeFragment -> {
                    fragment = HomeFragment()
                }
                R.id.mapsFragment -> {
                    fragment = MapsFragment()
                }
                R.id.notificationFragment -> {
                    fragment = NotificationFragment()
                }
                R.id.accountsFragment -> {
                    fragment = AccountsFragment()
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName()).commit()
            true
        }*/
    }
}