package com.example.androidcar

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidcar.ui.details.CarDetailsFragment

class MainActivity : AppCompatActivity(), CarCommunicator{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun passCar(car: Car) {
        val bundle = Bundle()

        bundle.putInt("id", car.id)

        val transaction = this.supportFragmentManager.beginTransaction()
        val detailsFragment = CarDetailsFragment()
        detailsFragment.arguments = bundle

        transaction.add(R.id.nav_host_fragment, detailsFragment)
        transaction.addToBackStack(CarDetailsFragment::class.java.name)

        val navBar : BottomNavigationView = findViewById(R.id.nav_view)
        navBar.menu.forEach { menuItem ->
            menuItem.isEnabled = false
            menuItem.isCheckable = false
        }

        transaction.commit()
    }

    override fun onBackPressed() {
        val navBar : BottomNavigationView = findViewById(R.id.nav_view)
        navBar.menu.forEach {
            it.isEnabled = true
            it.isCheckable = true
        }

        // find the displayed fragment and change title
        val navHostFragment = supportFragmentManager.primaryNavigationFragment
        val fragment = navHostFragment?.childFragmentManager?.fragments?.get(0)
        if ( fragment is DynamiqueTitleFragment ) {
            title = (fragment as DynamiqueTitleFragment).onTitleChanged()
        }

        return super.onBackPressed()
    }
}