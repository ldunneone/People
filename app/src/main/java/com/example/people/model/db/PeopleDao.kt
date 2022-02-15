package com.example.people.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.people.data.PersonResponse
import com.example.people.model.db.DatabaseConstants.DELETE_ALL_PEOPLE_QUERY
import com.example.people.model.db.DatabaseConstants.SELECT_ALL_PEOPLE_QUERY

@Dao
interface PeopleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPeople(personResponse: PersonResponse)

    @Query(SELECT_ALL_PEOPLE_QUERY)
    fun getAllPeople() : LiveData<PersonResponse>

    @Query(DELETE_ALL_PEOPLE_QUERY)
    fun deleteAllPeople()

}