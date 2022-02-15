package com.example.people.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.people.data.Person

class PersonDetailsViewModel: ViewModel() {

    private val _selectedPerson = MutableLiveData<Person>()

    val selectedPerson: LiveData<Person>
        get() = _selectedPerson

    fun setPerson(characterProperty: Person){
        _selectedPerson.value = characterProperty
    }

}