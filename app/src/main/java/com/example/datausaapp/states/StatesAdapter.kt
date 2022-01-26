package com.example.datausaapp.states

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datausaapp.R
import com.example.datausaapp.data.model.State

class StatesAdapter(private val onItemClick: (State) -> Unit) :
    RecyclerView.Adapter<StatesAdapter.CityViewHolder>(), Filterable {

    private var list = listOf<State>()
    private var lisfilter = listOf<State>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val context = parent.context
        val inflate = LayoutInflater.from(context)
        val contactView = inflate.inflate(R.layout.item_rv_city, parent, false)
        return CityViewHolder(contactView)

    }


    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(lisfilter[position])
    }

    override fun getItemCount(): Int {
        return lisfilter.size
    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tvName = itemView.findViewById<TextView>(R.id.name_city)
        private var tvPopulation = itemView.findViewById<TextView>(R.id.city_population)

        fun bind(state: State) {
            tvName.text = state.state
            tvPopulation.text = state.population.toString()


            itemView.setOnClickListener {
                onItemClick(state)
            }
        }
    }

    fun setupRecycleView(lista: List<State>) {
        list = lista
        lisfilter = list
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) {
                    lisfilter = list
                } else {
                    val filteredList = ArrayList<State>()
                    list
                        .filter {
                            (it.state.contains(constraint!!))

                        }
                        .forEach { filteredList.add(it) }
                    lisfilter = filteredList

                }
                return FilterResults().apply { values = lisfilter }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                lisfilter = if (results?.values == null) {
                    ArrayList()
                } else {
                    results.values as ArrayList<State>

                }
                notifyDataSetChanged()


            }
        }

    }
}
