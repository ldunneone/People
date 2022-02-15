package com.example.people.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.people.data.People
import com.example.people.data.Person
import com.example.people.databinding.RowPeopleItemBinding

class PersonAdapter(val callback: PersonClick) : RecyclerView.Adapter<PersonViewHolder>(){

    var personDataList = emptyList<People>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = RowPeopleItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.binding.also {
            it.person = personDataList[position]
            it.resultsCallback = callback
        }
    }

    override fun getItemCount(): Int {
        return personDataList.size
    }
}


class PersonViewHolder(val binding: RowPeopleItemBinding) : RecyclerView.ViewHolder(binding.root)

class PersonClick(val block: (People) -> Unit) {

    fun onClick(person: People) = block(person)
}