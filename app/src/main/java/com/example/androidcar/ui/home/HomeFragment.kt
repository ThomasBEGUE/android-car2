package com.example.androidcar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcar.Car
import com.example.androidcar.MyCarAdapter
import com.example.androidcar.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null

    private lateinit var recyclerView: RecyclerView

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


        return root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recyclerView.apply{
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView

            val cars = ArrayList<Car>()

            cars.add(Car("Titre 1", "description 1", 0, 2.5f))
            cars.add(Car("Titre 2", "description 2", 0, 2.5f))
            cars.add(Car("Titre 3", "description 3", 0, 2.5f))
            cars.add(Car("Titre 4", "description 4", 0, 2.5f))
            cars.add(Car("Titre 5", "description 5", 0, 2.5f))
            cars.add(Car("Titre 6", "description 6", 0, 2.5f))
            cars.add(Car("Titre 7", "description 7", 0, 2.5f))
            cars.add(Car("Titre 8", "description 8", 0, 2.5f))
            cars.add(Car("Titre 9", "description 9", 0, 2.5f))
            cars.add(Car("Titre 10", "description 10", 0, 2.5f))
            cars.add(Car("Titre 11", "description 11", 0, 2.5f))
            cars.add(Car("Titre 12", "description 12", 0, 2.5f))
            cars.add(Car("Titre 13", "description 13", 0, 2.5f))
            cars.add(Car("Titre 14", "description 14", 0, 2.5f))
            cars.add(Car("Titre 15", "description 15", 0, 2.5f))
            cars.add(Car("Titre 16", "description 16", 0, 2.5f))
            cars.add(Car("Titre 17", "description 17", 0, 2.5f))
            cars.add(Car("Titre 18", "description 18", 0, 2.5f))
            cars.add(Car("Titre 19", "description 19", 0, 2.5f))
            cars.add(Car("Titre 20", "description 20", 0, 2.5f))
            cars.add(Car("Titre 21", "description 21", 0, 2.5f))
            cars.add(Car("Titre 22", "description 22", 0, 2.5f))
            cars.add(Car("Titre 23", "description 23", 0, 2.5f))
            cars.add(Car("Titre 24", "description 24", 0, 2.5f))
            cars.add(Car("Titre 25", "description 25", 0, 2.5f))

            adapter = MyCarAdapter(cars, itemView.context)
        }
    }

}