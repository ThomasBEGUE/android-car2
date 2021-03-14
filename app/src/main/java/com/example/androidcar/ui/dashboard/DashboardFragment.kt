package com.example.androidcar.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidcar.DynamiqueTitleFragment
import com.example.androidcar.R

class DashboardFragment : Fragment(), DynamiqueTitleFragment {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        activity?.title = onTitleChanged()
        return root
    }

    override fun onTitleChanged(): String? {
        return context?.resources?.getString(R.string.title_create_car);
    }
}