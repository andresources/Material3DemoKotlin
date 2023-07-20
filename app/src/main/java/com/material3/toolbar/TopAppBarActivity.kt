package com.material3.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.shape.MaterialShapeDrawable
import com.material3.R
import java.security.AccessController.getContext

/*
Step 1: implementation 'com.google.android.material:material:1.9.0'
Step 2: theme file -> <style name="Theme.Material3" parent="Theme.Material3.DayNight.NoActionBar">


 */
class TopAppBarActivity : AppCompatActivity() {
    private lateinit var topAppBar: MaterialToolbar
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_app_bar)
        topAppBar = findViewById(R.id.topAppBar)
        appBarLayout = findViewById(R.id.appBarLayout)
        //setSupportActionBar(topAppBar) //step: 1
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    Toast.makeText(applicationContext, "Fav...", Toast.LENGTH_LONG).show()
                    true
                }
                else ->  menuItem.onNavDestinationSelected(findNavController(R.id.nav_host_frg))
                        || super.onOptionsItemSelected(menuItem)
            }
        }

    }
    //setSupportActionBar(topAppBar) //step: 1 in OnCreate()
    /*Step 1:
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val retValue = super.onCreateOptionsMenu(menu)
        getMenuInflater().inflate(R.menu.top_app_bar, menu);
        return retValue
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.favorite ->{
                Toast.makeText(applicationContext, "Fav...", Toast.LENGTH_LONG).show()
                return true
            }
            else ->{
                return item.onNavDestinationSelected(findNavController(R.id.nav_host_frg))
                        || super.onOptionsItemSelected(item)
            }

        }
    }*/
}