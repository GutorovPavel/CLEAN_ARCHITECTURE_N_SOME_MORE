package com.example.tutors.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.tutors.data.storage.User
import com.example.tutors.data.storage.UserStorage
import com.example.tutors.domain.models.SaveUserNameParam
import com.example.tutors.domain.models.UserName
import com.example.tutors.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(saveParam.name, "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(user.firstName, user.lastName)
    }

}