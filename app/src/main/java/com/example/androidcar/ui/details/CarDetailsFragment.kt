package com.example.androidcar.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.androidcar.DynamiqueTitleFragment
import com.example.androidcar.R
import com.example.androidcar.databinding.CarDetailsFragmentBinding

class CarDetailsFragment : Fragment(), DynamiqueTitleFragment {

    private var binding: CarDetailsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProvider(this).get(CarDetailsViewModel::class.java)
        val carId = arguments?.getInt("id", -1)

        if (carId?.compareTo(0)!! >= 0) {
            viewModel.setCarById(carId)
        }

        binding = CarDetailsFragmentBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = this@CarDetailsFragment
            this.viewModel = viewModel
        }

        activity?.title = onTitleChanged()
        return binding!!.root
    }

    override fun onTitleChanged(): String? {
        return context?.resources?.getString(R.string.title_details_car);
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}