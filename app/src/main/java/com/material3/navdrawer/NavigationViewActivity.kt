package com.material3.navdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.google.android.material.navigation.NavigationView
import com.material3.R

class NavigationViewActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_view)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        var toggle: ActionBarDrawerToggle =ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    Toast.makeText(applicationContext, "Fav...", Toast.LENGTH_LONG).show()
                    true
                }
                else ->  menuItem.onNavDestinationSelected(findNavController(R.id.nav_host_frg))
                        || super.onOptionsItemSelected(menuItem)
            }
            menuItem.setChecked(true);
            menuItem.isChecked = true
            drawerLayout.close()
            true
        }
        navigationView.setCheckedItem(R.id.favorite)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            finish()
        }
    }
    /*
    Step 1: implements NavigationView.OnNavigationItemSelectedListener
    Step 2:  navigationView.setNavigationItemSelectedListener(this);
             navigationView.setCheckedItem(R.id.nav_camera);
    Step 3: @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        }


     */
}