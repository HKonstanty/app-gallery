package com.example.mygallery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mygallery.R
import com.example.mygallery.models.Car
import kotlinx.android.synthetic.main.layout_car_item.view.*
import android.widget.ImageButton
import androidx.core.graphics.createBitmap
import androidx.navigation.findNavController
//import kotlinx.android.synthetic.main.fragment_item.view.*


class CarAdapter(private var itemsList: MutableList<Car>, var clickLisner: OnCarItemClickLisner) : RecyclerView.Adapter<CustomViewHolder>() {
    /**
     * dostaje liste samochodow i klase zarzadzajaca zdarzeniami klikniecia
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.layout_car_item, parent,false)
        return CustomViewHolder(cellForRow)
    }

    fun getItemsList() : MutableList<Car>{
        return itemsList
    }

    fun setItemsList(newItemsList: MutableList<Car>): Boolean{
        itemsList = newItemsList
        return true
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.initilize(itemsList[position], clickLisner)
    }

    fun removeItem(viewHolder: CustomViewHolder){
        itemsList.removeAt(viewHolder.adapterPosition)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}

class CustomViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val name: TextView = view.findViewById(R.id.tvName)
    val model: TextView = view.findViewById(R.id.modelTV)
    val power: TextView = view.findViewById(R.id.powerTV)
    val engCap:TextView = view.findViewById(R.id.engCapTV)
    val image: ImageView = view.findViewById(R.id.imageView)
    val switch: Switch = view.findViewById(R.id.favSW)

    fun initilize(item: Car, action: OnCarItemClickLisner){
        name.text = item.name
        model.text = item.model
        power.text = item.power
        engCap.text = item.engineCap
        image.setImageResource(item.imageID)
        switch.isChecked = item.isFav

        itemView.findViewById<Switch>(R.id.favSW).setOnClickListener {
            action.onSwitchChanged(item, adapterPosition)
        }
        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }
    }
}

interface OnCarItemClickLisner{
    fun onItemClick(item : Car, position: Int)
    fun onSwitchChanged(item: Car, position: Int)
}
