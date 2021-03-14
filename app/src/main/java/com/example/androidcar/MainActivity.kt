package com.example.androidcar

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
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

        bundle.putString("model", car.brands + " " + car.model)
        bundle.putString("registration", car.registration)
        bundle.putString("fuel", car.fuel)
        car.numberOfPlaces?.let { bundle.putInt("numberOfPlaces", it) }
        car.numberOfDoors?.let { bundle.putInt("numberOfDoors", it) }
        car.price?.let { bundle.putInt("price", it) }
        bundle.putString("description", car.description)

        val transaction = this.supportFragmentManager.beginTransaction()
        val detailsFragment = CarDetailsFragment()
        detailsFragment.arguments = bundle

        transaction.replace(R.id.container, detailsFragment)
        transaction.commit()
    }
}