package com.example.people.di

import android.app.Application
import androidx.room.Room
import com.example.people.model.db.DatabaseConstants.PEOPLE_DATABASE_NAME
import com.example.people.model.db.PeopleDao
import com.example.people.model.db.PeopleDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application) : PeopleDatabase {
        return Room.databaseBuilder(application, PeopleDatabase::class.java, PEOPLE_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: PeopleDatabase) : PeopleDao {
        return database.getPeopleDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }


}