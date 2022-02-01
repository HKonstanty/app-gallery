package com.example.mygallery.viewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mygallery.R
import com.example.mygallery.viewPager.screens.Description
import com.example.mygallery.viewPager.screens.Detalis
import com.example.mygallery.viewPager.screens.Fotos
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        val fragmentList = arrayListOf(
            Detalis(),
            Fotos(),
            Description()
        )
        val adapter = ViewPagerAdapter(fragmentList, childFragmentManager, lifecycle)
        view.viewPager.adapter = adapter
        return view
    }
}