package com.example.tutors.domain.usecases

import com.example.tutors.domain.models.SaveUserNameParam
import com.example.tutors.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(param)
    }
}