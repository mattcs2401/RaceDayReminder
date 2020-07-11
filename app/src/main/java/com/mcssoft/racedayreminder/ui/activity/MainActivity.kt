package com.mcssoft.racedayreminder.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mcssoft.racedayreminder.R
import com.mcssoft.racedayreminder.databinding.MainActivityBinding
import com.mcssoft.racedayreminder.utility.Constants

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var binding: MainActivityBinding? = null
    private lateinit var navController: NavController
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

//        // Cancel any previous notifications.
//        // TODO - this the right place in lifecycle ?
//        (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).cancelAll()

//        // Check RacePreferences (if not set, then set them to defaults)
//        iRacePreferences.preferencesCheck()

        // Toolbar.
        setSupportActionBar(binding!!.idToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Navigation.
        navController = Navigation.findNavController(this, R.id.id_nav_host_fragment)
        bottomNavView = binding!!.idBottomNavView
        NavigationUI.setupWithNavController(bottomNavView, navController)
        bottomNavView.setOnNavigationItemSelectedListener(this)

        // Back Navigation.
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    //<editor-fold default state="collapsed" desc="Region: Bottom navigation listener">
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId) {
            R.id.id_mnu_bnv_settings -> {
                // Bottom navigation menu Settings.
                navController.navigate(R.id.id_preferences_fragment)
            }
            R.id.id_mnu_bnv_add -> {
                // Bottom navigation menu Add.
                val bundle = Bundle()
                bundle.putInt(getString(R.string.key_edit_type), Constants.EDIT_RACE_NEW)
                navController.navigate(R.id.id_edit_fragment, bundle)
            }
        }
        return false
    }
    //</editor-fold>
}