package com.example.tutors.di

import com.example.tutors.domain.usecases.GetUserNameUseCase
import com.example.tutors.domain.usecases.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        SaveUserNameUseCase(get())
    }

    factory {
        GetUserNameUseCase(get())
    }

}