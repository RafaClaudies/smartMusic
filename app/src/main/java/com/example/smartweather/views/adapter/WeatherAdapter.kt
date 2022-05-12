package com.example.smartweather.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.smartweather.data.Datum
import com.example.smartweather.databinding.ItemWeatherBinding

class WeatherAdapter(private val weatherList: MutableList<Datum>, private val action: (item: Datum) -> Unit) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(weatherList[position], action)
    }

    override fun getItemCount(): Int = weatherList.size

    class ViewHolder(private val itemBinding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindItem(itemInfo: Datum, action: (item: Datum) -> Unit) {

            itemBinding.apply {

                icArtist.load(itemInfo.album?.coverSmall)
                txvTitle.text = itemInfo.title
                txvSubtitle.text = itemInfo.artist?.name ?: ""

                bodyItem.setOnClickListener {
                    action(itemInfo)
                }

            }

        }

    }

}