package com.example.tutors.presentation.screens.CleanArchitecture

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tutors.APP
import com.example.tutors.data.repository.UserRepositoryImpl
import com.example.tutors.data.storage.SharedPrefsUserStorage
import com.example.tutors.domain.models.SaveUserNameParam
import com.example.tutors.domain.usecases.GetUserNameUseCase
import com.example.tutors.domain.usecases.SaveUserNameUseCase

class CleanArchitectureViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
    ): ViewModel() {


    private val resultText = MutableLiveData<String>()
    val text: LiveData<String> = resultText

    fun save(text: String) {
        val params = SaveUserNameParam(text)
        val result = saveUserNameUseCase.execute(params)
        resultText.value = "Save result: $result"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultText.value = userName.firstName + userName.lastName
    }
}