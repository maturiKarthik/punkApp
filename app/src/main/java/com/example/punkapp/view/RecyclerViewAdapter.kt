package com.example.punkapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.punkapp.R
import com.example.punkapp.databinding.ItemBinding
import com.example.punkapp.model.PunKData
import com.example.punkapp.util.BeerClickListener
import kotlinx.android.synthetic.main.item.view.*

class RecyclerViewAdapter(var dataSet: List<PunKData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(), BeerClickListener {

    fun setData(punkData: List<PunKData>) {
        this.dataSet = punkData
        notifyDataSetChanged()
    }

    class ViewHolder(val view: ItemBinding) : RecyclerView.ViewHolder(view.root)


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val itemBinding = DataBindingUtil.inflate<ItemBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.item,
            viewGroup,
            false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.view.punkData = dataSet[position]
        viewHolder.view.clickListener = this
    }

    override fun getItemCount() = dataSet.size

    //On Click Event
    override fun onBeerClicked(view: View) {
        val id = view.uid.text.toString().toInt()
        val action = ListFragmentDirections.actionListFragmentToDetailFragment()
        action.uuid = id
        Navigation.findNavController(view).navigate(action)
    }
}
