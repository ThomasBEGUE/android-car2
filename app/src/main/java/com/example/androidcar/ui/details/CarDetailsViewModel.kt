package com.example.androidcar.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcar.Car
import com.example.androidcar.CarRepository

class CarDetailsViewModel() : ViewModel() {
    // Implement the ViewModel

    private val _model = MutableLiveData<String?>()
    val model : LiveData<String?> = _model

    private val _registration = MutableLiveData<String?>()
    val registration : LiveData<String?> = _registration

    private val _fuel = MutableLiveData<String?>()
    val fuel : LiveData<String?> = _fuel

    private val _numberOfPlaces = MutableLiveData<Int?>()
    val numberOfPlaces : LiveData<Int?> = _numberOfPlaces

    private val _numberOfDoors = MutableLiveData<Int?>()
    val numberOfDoors : LiveData<Int?> = _numberOfDoors

    private val _price = MutableLiveData<Int?>()
    val price : LiveData<Int?> = _price

    private val _description = MutableLiveData<String>()
    val description : LiveData<String?> = _description

    private val _brands = MutableLiveData<String?>()
    val brands : LiveData<String?> = _brands

    fun setCarById(id: Int) {
        val car : Car? = CarRepository.findCarById(id)
        _model.value = car?.model
        _registration.value = car?.registration
        _fuel.value = car?.fuel
        _numberOfPlaces.value = car?.numberOfPlaces
        _numberOfDoors.value = car?.numberOfDoors
        _price.value = car?.price
        _brands.value = car?.brands
    }

    fun getFormattedPrice() : String {
        return price.value.toString() + "€"
    }

    fun getFullModel() : String {
        return brands.value + " " + model.value
    }

}