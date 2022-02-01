package com.example.mygallery.viewPager.screens

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mygallery.R
import com.example.mygallery.repositories.CarRepository
import kotlinx.android.synthetic.main.fragment_description.view.*


class Description : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_description, container, false)
        view.car_description.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        view.car_description.text = CarRepository.instance.getDescription(CarRepository.currentCar)

        return view
    }
}