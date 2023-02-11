package com.example.tutors.data.storage

import com.example.tutors.domain.models.SaveUserNameParam
import com.example.tutors.domain.models.UserName

interface UserStorage {

    fun save(user: User): Boolean
    fun get(): User
}