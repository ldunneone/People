package com.example.people.di

import com.example.people.model.network.PersonApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideUserApi(retrofit: Retrofit) : PersonApiService {
        return retrofit.create(PersonApiService::class.java)
    }

    single { provideUserApi(get()) }

}
