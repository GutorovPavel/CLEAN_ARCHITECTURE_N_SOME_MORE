package com.example.tutors.domain.usecases

import com.example.tutors.domain.models.UserName
import com.example.tutors.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }

}