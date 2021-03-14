package com.example.androidcar.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidcar.R

class CarDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = CarDetailsFragment()
    }

    private lateinit var viewModel: CarDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.car_details_fragment, container, false)

        // get all fields and passe data to it
        val modelText: TextView = root.findViewById(R.id.car_details_value_model)
        val registrationText: TextView = root.findViewById(R.id.car_details_value_registration)
        val fuelText: TextView = root.findViewById(R.id.car_details_value_fuel)
        val numberOfPlacesText: TextView = root.findViewById(R.id.car_details_value_number_of_places)
        val numberOfDoorsText: TextView = root.findViewById(R.id.car_details_value_number_of_doors)
        val priceText: TextView = root.findViewById(R.id.car_details_value_price)
        val descriptionText: TextView = root.findViewById(R.id.car_details_value_description)

        // set all values
        modelText.text = arguments?.getString("model");
        registrationText.text = arguments?.getString("registration");
        fuelText.text = arguments?.getString("fuel");
        numberOfPlacesText.text = arguments?.getInt("numberOfPlaces").toString();
        numberOfDoorsText.text = arguments?.getInt("numberOfDoors").toString();
        priceText.text = arguments?.getInt("price").toString();
        descriptionText.text = arguments?.getString("description");

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarDetailsViewModel::class.java)
        // Use the ViewModel

    }

}