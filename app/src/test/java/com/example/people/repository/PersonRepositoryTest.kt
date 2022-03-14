package com.example.people.repository

import com.example.people.data.PersonResponse
import com.example.people.model.db.PeopleDao
import com.example.people.model.network.PersonApiService
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class PersonRepositoryTest {

    lateinit var personRepository: PersonRepository
    lateinit var peopleDao: PeopleDao
    lateinit var peopleApiService: PersonApiService


    @Before
    fun setup(){
        peopleDao = Mockito.mock(PeopleDao::class.java)
        peopleApiService = Mockito.mock(PersonApiService::class.java)

        personRepository = PersonRepository(peopleDao, peopleApiService)
    }
    @Test
    fun whenStorePeopleData_thenInsertPeopleCalled(){
        val personResponse = PersonResponse(1, emptyList())
        Mockito.doNothing().`when`(peopleDao).insertPeople(personResponse)

        personRepository.storePersonData(personResponse)

        Mockito.verify(peopleDao).insertPeople(personResponse)
    }



}