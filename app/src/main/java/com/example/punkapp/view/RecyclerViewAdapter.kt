package com.example.punkapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.punkapp.R
import com.example.punkapp.model.PunKData
import com.example.punkapp.util.loadUrl
import kotlinx.android.synthetic.main.item.view.*

class RecyclerViewAdapter(var dataSet: List<PunKData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    fun setData(punkData: List<PunKData>) {
        this.dataSet = punkData
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.name.text = dataSet[position].name
        viewHolder.itemView.description.text = dataSet[position].description
        viewHolder.itemView.imageView.loadUrl(
            viewHolder.itemView.imageView,
            dataSet[position].image_url
        )
    }

    override fun getItemCount() = dataSet.size
}
