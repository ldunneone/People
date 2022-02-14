package com.example.people.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.people.data.People

class PersonAdapter(val callback: PersonClick) : RecyclerView.Adapter<PersonViewHolder>(){

    var personDataList = emptyList<People>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = RowPersonItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.binding.also {
            it.flight = personDataList[position]
            it.resultsCallback = callback
        }
    }

    override fun getItemCount(): Int {
        return personDataList.size
    }
}


class FlightViewHolder(val binding: RowPersonItemBinding) : RecyclerView.ViewHolder(binding.root)

class PersonClick(val block: (People) -> Unit) {

    fun onClick(person: People) = block(person)
}