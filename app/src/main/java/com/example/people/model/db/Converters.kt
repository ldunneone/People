package com.example.people.model.db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.people.data.People
import com.example.people.data.Person
import com.example.people.data.PersonResponse
import com.google.gson.Gson

class Converters{

    @TypeConverter
    fun peopleListToJson(people: List<People>) : String{
        return Gson().toJson(people)
    }


    @TypeConverter
    fun peopleListFromJson(value: String): List<People> {
        return Gson().fromJson(value, Array<People>::class.java).toList()
    }


    @TypeConverter
    fun personListToJson(person: List<Person>) : String{
        return Gson().toJson(person)
    }

    @TypeConverter
    fun personListFromJson(value: String): List<Person> {
        return Gson().fromJson(value, Array<Person>::class.java).toList()
    }

    @TypeConverter
    fun personResponseListToJson(people: PersonResponse) : String{
        return Gson().toJson(people)
    }


    @TypeConverter
    fun personResponseListFromJson(value: String): PersonResponse {
        return Gson().fromJson(value, PersonResponse::class.java)
    }




}