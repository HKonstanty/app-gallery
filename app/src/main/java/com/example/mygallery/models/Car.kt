package com.example.mygallery.models

class Car(
        val name: String,
        val category: Category,
        val model: String,
        val power: String,
        val engineCap: String,
        val imageID: Int,
        val info: String,
        var isFav: Boolean = false) {

    fun setFav(){
            isFav = !isFav
    }
}

enum class Category {
    FERRARI, LAMBORGHINI, ASTON_MARTIN
}