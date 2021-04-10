package com.example.androidcar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcar.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment(), OnCarItemClickListener, DynamiqueTitleFragment {

    private lateinit var communicator: CarCommunicator

    private lateinit var recyclerView: RecyclerView

    private lateinit var cars : List<Car>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = root.findViewById(R.id.recyclerView)
        communicator = activity as CarCommunicator

        val carListenerImpl = this
        recyclerView.apply{
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView

            cars = CarRepository.cars
            adapter = MyCarAdapter(CarRepository.cars, carListenerImpl)

            activity?.title = onTitleChanged()
        }

        return root
    }

    override fun onItemClick(car: Car, position: Int) {
        communicator.passCar(car);
    }

    override fun onResume() {
        super.onResume()
        val navBar : BottomNavigationView? = activity?.findViewById(R.id.nav_view)
        navBar?.menu?.forEach {
            it.isEnabled = true
            it.isCheckable = true
        }
    }

    override fun onTitleChanged(): String? {
        return context?.resources?.getQuantityString(R.plurals.number_of_cars, cars.size, cars.size);
    }

}