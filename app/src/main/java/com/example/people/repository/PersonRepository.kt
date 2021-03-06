package com.example.people.repository

import android.util.Log
import com.example.people.data.Person
import com.example.people.data.PersonResponse
import com.example.people.model.db.PeopleDao
import com.example.people.model.network.PersonApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

open class PersonRepository(
    private val personDao: PeopleDao,
    private val personApiService: PersonApiService
) {

    suspend fun getPeople() {
        withContext(Dispatchers.IO) {
            try {
                val personData = personApiService.getAllPeople().await()
                storePersonData(PersonResponse(1, personData.map {
                    Person(
                        it.avatar,
                        it.createdAt,
                        it.email,
                        it.favouriteColor,
                        it.firstName,
                        it.id,
                        it.jobTitle,
                        it.lastName,
                        it.latitude,
                        it.longitude,
                        it.phone
                    )
                }))
            } catch (exception: HttpException) {
                Log.d("HTTP-EX", exception.message())
            }
        }
    }

    fun storePersonData(personResponse: PersonResponse) {
        personDao.insertPeople(personResponse)
    }

    val personData = personDao.getAllPeople()
}