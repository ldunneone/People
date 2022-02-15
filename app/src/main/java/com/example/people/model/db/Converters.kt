package com.example.people.model.db

import androidx.room.TypeConverter
import com.example.people.data.People
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




}