package com.example.tutors.domain.repository

import com.example.tutors.domain.models.SaveUserNameParam
import com.example.tutors.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}