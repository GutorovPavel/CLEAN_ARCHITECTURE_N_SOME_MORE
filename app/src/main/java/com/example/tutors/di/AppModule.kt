package com.example.tutors.di

import com.example.tutors.presentation.screens.CleanArchitecture.CleanArchitectureViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        CleanArchitectureViewModel(get(), get())
    }
}