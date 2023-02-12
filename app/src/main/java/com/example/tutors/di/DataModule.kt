package com.example.tutors.di

import com.example.tutors.data.repository.UserRepositoryImpl
import com.example.tutors.data.storage.SharedPrefsUserStorage
import com.example.tutors.data.storage.UserStorage
import com.example.tutors.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(get())
    }
    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}