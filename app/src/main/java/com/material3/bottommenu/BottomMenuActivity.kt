package com.material3.bottommenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.material3.R

class BottomMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_menu)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        var badge = navView.getOrCreateBadge(R.id.firstFragment)
        badge.isVisible = true
        badge.number = 99
        //navView.setupWithNavController(findNavController(R.id.nav_host_frg))
        /*navView.setOnNavigationItemSelectedListener{menuItem->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    Toast.makeText(applicationContext, "Fav...", Toast.LENGTH_LONG).show()
                    true
                }
                else -> menuItem.onNavDestinationSelected(findNavController(R.id.nav_host_frg))
                        || super.onOptionsItemSelected(menuItem)
            }
        }*/
    }
}