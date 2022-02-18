package com.example.people.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.people.data.PersonResponse
import com.example.people.model.db.DatabaseConstants.EXPORT_SCHEMA
import com.example.people.model.db.DatabaseConstants.PEOPLE_DATABASE_VERSION


@Database(entities = [PersonResponse::class], version = PEOPLE_DATABASE_VERSION, exportSchema = EXPORT_SCHEMA)
@TypeConverters(Converters::class)
abstract class PeopleDatabase : RoomDatabase() {
    abstract fun getPeopleDao() : PeopleDao
}