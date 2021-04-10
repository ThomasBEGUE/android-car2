package com.example.androidcar

object CarRepository {

    val cars = listOf<Car>(
        Car(
            id = 1,
            brands = "Peugeot",
            model = "2008",
            registration = "ER7652PO",
            fuel = "Diesel",
            numberOfPlaces = 2,
            numberOfDoors = 3,
            description = "Belle voiture, en bon état.",
            price = 50,
            stars = 4f
        ),
        Car(
            id = 2,
            brands = "Land Rover",
            model = "Evoque",
            registration = "AA111AA",
            fuel = "Diesel",
            numberOfPlaces = 5,
            numberOfDoors = 5,
            description = "En bon état.",
            price = 120,
            stars = 5f
        ),
        Car(
            id = 3,
            brands = "Land Rover",
            model = "Evoque",
            registration = "AB123CD",
            fuel = "Essence",
            numberOfPlaces = 5,
            numberOfDoors = 5,
            description = "Bof bof",
            price = 50,
            stars = 2.5f
        )
    )

    fun findCarById(id: Int) : Car? {
        for(car: Car in cars) {
            if(car.id == id) {
                return car
            }
        }
        return null
    }
}