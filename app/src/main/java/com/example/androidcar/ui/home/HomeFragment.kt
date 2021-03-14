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

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var communicator: CarCommunicator

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null

    private lateinit var recyclerView: RecyclerView

    private lateinit var cars : ArrayList<Car>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = root.findViewById(R.id.recyclerView)

        // val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            // textView.text = it
        })

        communicator = activity as CarCommunicator

        val carListenerImpl = this
        recyclerView.apply{
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView

            cars = getMockedCars()
            adapter = MyCarAdapter(cars, carListenerImpl)

            activity?.title = onTitleChanged()
        }

        return root
    }

    private fun getMockedCars() : ArrayList<Car>{

        val cars = ArrayList<Car>()

        // Add some default values before change to api call
        cars.add(Car(
            id = 1,
            brands = "Peugeot",
            model = "2008",
            registration = "ER7652PO",
            fuel = "Diesel",
            numberOfPlaces = 5,
            numberOfDoors = 5,
            description = "Belle voiture, en bon état.",
            price = 50,
            stars = 4f))

        cars.add(Car(
            id = 2,
            brands = "Land Rover",
            model = "Evoque",
            registration = "AA111AA",
            fuel = "Diesel",
            numberOfPlaces = 5,
            numberOfDoors = 5,
            description = "En bon état.",
            price = 120,
            stars = 5f))

        cars.add(Car(
            id = 3,
            brands = "Land Rover",
            model = "Evoque",
            registration = "AB123CD",
            fuel = "Essence",
            numberOfPlaces = 5,
            numberOfDoors = 5,
            description = "Bof bof",
            price = 50,
            stars = 2.5f))

        return cars
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

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