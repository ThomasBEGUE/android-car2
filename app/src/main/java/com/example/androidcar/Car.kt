package com.example.androidcar

class Car(
    val id: Int,
    val brands: String? = "",
    val model: String? = "",
    val registration: String? = "",
    val fuel: String? = "",
    val numberOfPlaces: Int? = 2,
    val numberOfDoors: Int? = 2,
    val description: String? = "",
    val price: Int? = 0,
    val image: Int? = null,
    val stars: Float = 0f) {
}