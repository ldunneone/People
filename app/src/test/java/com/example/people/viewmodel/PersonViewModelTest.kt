package com.example.people.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.people.repository.PersonRepository
import com.example.people.util.CoroutineTestRule
import com.example.people.util.LoadingState
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

import org.mockito.Mockito

class PersonViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @get:Rule
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var loadingStateObserver: Observer<LoadingState>

    private lateinit var personRepository: PersonRepository

    private lateinit var personViewModel: PersonViewModel

    @Before
    fun setUp() {


        personRepository = Mockito.mock(PersonRepository::class.java)

        personViewModel = PersonViewModel(personRepository)

        loadingStateObserver = Mockito.mock(Observer::class.java) as Observer<LoadingState>
        personViewModel.loadingState.observeForever(loadingStateObserver)
    }

    @Test
    fun whenGetPeopleData_thenGetPeopleCalled() = runBlocking {


        Mockito.`when`(personRepository.getPeople()).thenReturn(null)

        // When
        personViewModel.getPersonData()

        // Then
        Mockito.verify(personRepository, Mockito.times(2)).getPeople()
        Mockito.verify(loadingStateObserver).onChanged(LoadingState.LOADING)
    }

    @After
    fun tearDown(){

    }

}