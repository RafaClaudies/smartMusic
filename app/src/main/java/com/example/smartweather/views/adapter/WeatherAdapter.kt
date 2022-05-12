package com.example.smartweather.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartweather.databinding.ItemWeatherBinding

class WeatherAdapter(private val weatherList: MutableList<String>, private val action: (item: String) -> Unit) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(weatherList[position], action)
    }

    override fun getItemCount(): Int = weatherList.size

    class ViewHolder(private val itemBinding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindItem(weather: String, action: (item: String) -> Unit) {

            itemBinding.apply {

                txvTitle.text = "Dia"
                txvSubtitle.text = "Clima"

                bodyItem.setOnClickListener {
                    action("")
                }

            }

        }

    }

}

/*
class ModulesAdapter(private val officeList: MutableList<Triple<ModulesRV, ModulesRV, ModulesRV>>, private val action: (item: ModulesRV) -> Unit) : RecyclerView.Adapter<ModulesAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(officeList[position], action)
    }

    class ViewHolder(private val itemBinding: ItemThreeButtomsBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val preferencesManager = PreferencesManager

        fun bindItem(listModules: Triple<ModulesRV, ModulesRV, ModulesRV>, action: (item: ModulesRV) -> Unit) {
            itemBinding.apply {

                if (!listModules.first.nombre!!.isEmpty()) {
                    tvItemBtn1.text = listModules.first.nombre
                    ivItemBtn1.setImageResource(listModules.first.icon!!)
                    ivItemBtn1.setColorFilter(Color.parseColor("${preferencesManager.secondaryColor}"))
                    btnCard1.setOnClickListener {
                        action(listModules.first)
                    }
                } else {
                    btnCard1.visibility = View.INVISIBLE
                }

                if (!listModules.second.nombre!!.isEmpty()) {
                    tvItemBtn2.text = listModules.second.nombre
                    ivItemBtn2.setImageResource(listModules.second.icon!!)
                    ivItemBtn2.setColorFilter(Color.parseColor("${preferencesManager.secondaryColor}"))

                    btnCard2.setOnClickListener {
                        action(listModules.second)
                    }
                } else {
                    btnCard2.visibility = View.INVISIBLE
                }

                if (!listModules.third.nombre!!.isEmpty()) {
                    tvItemBtn3.text = listModules.third.nombre
                    ivItemBtn3.setImageResource(listModules.third.icon!!)
                    ivItemBtn3.setColorFilter(Color.parseColor("${preferencesManager.secondaryColor}"))

                    btnCard3.setOnClickListener {
                        action(listModules.third)
                    }
                } else {
                    btnCard3.visibility = View.INVISIBLE
                }


                //strItem.text = item.nombre
                //bodyItem.setOnClickListener { action(item) }
            }
        }
    }

}
 */