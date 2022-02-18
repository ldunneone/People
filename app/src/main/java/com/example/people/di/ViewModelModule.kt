package com.example.people.di

import com.example.people.viewmodel.PersonDetailsViewModel
import com.example.people.viewmodel.PersonViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PersonViewModel(get()) }
    viewModel{ PersonDetailsViewModel() }
}