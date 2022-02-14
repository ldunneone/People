package com.example.people.model.network

import com.example.people.data.People
import com.example.people.model.network.NetworkConstants.PERSON_DATA_ENDPOINT
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface  PersonApiService {

    @GET(PERSON_DATA_ENDPOINT)
    fun getAllPeople() : Deferred<List<People>>


}