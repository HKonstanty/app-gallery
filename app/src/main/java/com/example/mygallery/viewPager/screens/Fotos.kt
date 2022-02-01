package com.example.mygallery.viewPager.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygallery.R
import com.example.mygallery.repositories.CarRepository
import kotlinx.android.synthetic.main.fragment_fotos.view.*

class Fotos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fotos =  CarRepository.instance.getFotos(CarRepository.currentCar)
        val view =  inflater.inflate(R.layout.fragment_fotos, container, false)
        view.foto1.setImageResource(fotos[0])
        view.foto2.setImageResource(fotos[1])
        view.foto3.setImageResource(fotos[2])

        return view
    }
}