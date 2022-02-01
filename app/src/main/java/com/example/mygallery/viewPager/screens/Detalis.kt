package com.example.mygallery.viewPager.screens

import android.graphics.text.LineBreaker
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mygallery.R
import com.example.mygallery.repositories.CarRepository
import kotlinx.android.synthetic.main.fragment_description.view.*
import kotlinx.android.synthetic.main.fragment_detalis.view.*
import kotlinx.android.synthetic.main.fragment_fotos.view.*


class Detalis : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val car =  CarRepository.instance.getCar(CarRepository.currentModel)
        val view =  inflater.inflate(R.layout.fragment_detalis, container, false)
        view.infoTV.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        view.setNameTV.text = car.name
        view.setModelTV.text = car.model
        view.setPowerTV.text = car.power
        view.setCapTV.text = car.engineCap
        view.infoTV.text = car.info
        view.carImage.setImageResource(car.imageID)

        return view
    }
}