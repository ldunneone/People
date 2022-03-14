package com.example.people.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.people.data.Person
import com.example.people.repository.PersonRepository
import com.example.people.util.LoadingState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.HttpException

class PersonViewModel(
    private val personRepository: PersonRepository
) : ViewModel()
{

    val personData = personRepository.personData
    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    //val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    init {
        viewModelScope.launch {
            getPersonData()
        }
    }

    suspend fun getPersonData() {
        try {
            _loadingState.value = LoadingState.LOADING
            personRepository.getPeople()
            _loadingState.value = LoadingState.LOADED
        }
        catch (exception: HttpException){
            _loadingState.value = LoadingState.logError(exception.message())
        }

    }

    //for display data in second fragment
    // LiveData to handle navigation to the selected Character
    private val _navigateToSelectedPerson = MutableLiveData<Person?>()
    val navigateToSelectedPerson: MutableLiveData<Person?>
        get() = _navigateToSelectedPerson

    fun displayPersonDetails(characterProperty: Person) {
        _navigateToSelectedPerson.value = characterProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedPerson.value = null
    }
}
