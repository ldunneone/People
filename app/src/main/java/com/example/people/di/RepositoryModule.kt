package com.example.people.di

import com.example.people.model.db.PeopleDao
import com.example.people.model.network.PersonApiService
import com.example.people.repository.PersonRepository
import org.koin.dsl.module

val repoModule = module {
    fun provideRepository(dao: PeopleDao, apiService: PersonApiService) : PersonRepository {
        return PersonRepository(dao, apiService)
    }

    single { provideRepository(get(), get()) }
}