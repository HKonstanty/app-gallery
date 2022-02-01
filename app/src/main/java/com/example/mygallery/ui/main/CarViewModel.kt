package com.example.mygallery.ui.main

import androidx.lifecycle.ViewModel
import com.example.mygallery.models.Car
import com.example.mygallery.repositories.CarRepository

class CarViewModel : ViewModel() {
    //private lateinit var mCarList : MutableList<Car>
    private lateinit var carRepo : CarRepository

    fun init() : Unit {
        carRepo = CarRepository().getInstance()
        carRepo.initialize()
    }

    fun deleteCar(name: String){
        carRepo.deleteCar(name)
    }

    fun getCarList() : MutableList<Car> {
        return carRepo.getDataSet()
    }

    fun getFerrariList() : MutableList<Car> {
        return carRepo.getFerrari()
    }

    fun getLamboList() : MutableList<Car> {
        return carRepo.getLamborghini()
    }

    fun getAstonList() : MutableList<Car> {
        return carRepo.getAston()
    }

    fun getFavList() : MutableList<Car> {
        return carRepo.getFavourite()
    }
}