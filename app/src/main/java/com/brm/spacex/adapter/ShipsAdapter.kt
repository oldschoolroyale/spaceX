package com.brm.spacex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brm.spacex.R
import com.brm.spacex.data.model.ship.Ship
import com.squareup.picasso.Picasso

class ShipsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList = arrayListOf<Ship>()

    fun newList(list: ArrayList<Ship>){
        this.dataList = list
        notifyDataSetChanged()
    }

    fun addShip(ship: Ship){
        dataList.add(ship)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShipsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ships_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ShipsViewHolder)
            holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    private inner class ShipsViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val image = view.findViewById<ImageView>(R.id.item_iv)
        private val title = view.findViewById<TextView>(R.id.topic_tv)
        private val description = view.findViewById<TextView>(R.id.description_tv)

        fun bind(ship: Ship){
            Picasso.get().load(ship.image).into(image)
            title.text = ship.name
            description.text = "${itemView.context.getString(R.string.year_build)}: ${ship.year_built}"
        }
    }
}