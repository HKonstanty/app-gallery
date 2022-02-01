package com.example.mygallery.ui.main

import android.os.Bundle
import android.view.*
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygallery.R
import com.example.mygallery.adapters.CustomViewHolder
import com.example.mygallery.adapters.CarAdapter
import com.example.mygallery.adapters.OnCarItemClickLisner
import com.example.mygallery.models.Car
import com.example.mygallery.repositories.CarRepository
import kotlinx.android.synthetic.main.layout_car_item.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(), OnCarItemClickLisner {

    private lateinit var  favSw : Switch

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: CarViewModel
    private lateinit var adapterMA: CarAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater.inflate(R.layout.main_fragment, container, false)
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)
        viewModel.init()
        return view
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        adapterMA = CarAdapter(viewModel.getCarList(), this)
        recycler_view.adapter = adapterMA
        recycler_view.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        recycler_view.setHasFixedSize(true)

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Toast.makeText(activity, (viewHolder as CustomViewHolder).model.text.toString(), Toast.LENGTH_SHORT).show()
                viewModel.deleteCar((viewHolder as CustomViewHolder).model.text.toString())
                adapterMA.removeItem(viewHolder)
            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    override fun onItemClick(item: Car, position: Int) {
        CarRepository.currentCar = item.name
        CarRepository.currentModel = item.model
        Navigation.findNavController(requireView()).navigate(R.id.viewPagerFragment)
    }

    override fun onSwitchChanged(item: Car, position: Int) {
        item.setFav()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.allIt -> selectedAll()
            R.id.ferrariIt -> selectedFerrari()
            R.id.lamboIt -> selectedLambo()
            R.id.astonIt -> selectedAston()
            R.id.favIt -> favSelected()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun selectedAll() {
        adapterMA.setItemsList(viewModel.getCarList())
        adapterMA.notifyDataSetChanged()
    }

    private fun selectedFerrari() {
        adapterMA.setItemsList(viewModel.getFerrariList())
        adapterMA.notifyDataSetChanged()
    }

    private fun selectedLambo() {
        adapterMA.setItemsList(viewModel.getLamboList())
        adapterMA.notifyDataSetChanged()
    }

    private fun selectedAston() {
        adapterMA.setItemsList(viewModel.getAstonList())
        adapterMA.notifyDataSetChanged()
    }

    private fun favSelected() {
        adapterMA.setItemsList(viewModel.getFavList())
        adapterMA.notifyDataSetChanged()
    }
}