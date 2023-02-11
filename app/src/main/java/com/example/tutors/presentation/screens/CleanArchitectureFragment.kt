package com.example.tutors.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tutors.APP
import com.example.tutors.data.repository.UserRepositoryImpl
import com.example.tutors.data.storage.SharedPrefsUserStorage
import com.example.tutors.databinding.FragmentCleanArchitectureBinding
import com.example.tutors.domain.models.SaveUserNameParam
import com.example.tutors.domain.usecases.GetUserNameUseCase
import com.example.tutors.domain.usecases.SaveUserNameUseCase

class CleanArchitectureFragment : Fragment() {

    lateinit var binding: FragmentCleanArchitectureBinding

    private val userRepository = UserRepositoryImpl(SharedPrefsUserStorage(APP.applicationContext)
    )
    private val getUserNameUseCase = GetUserNameUseCase(userRepository)
    private val saveUserNameUseCase = SaveUserNameUseCase(userRepository)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCleanArchitectureBinding.inflate(layoutInflater, container, false)
        init()

        return binding.root
    }

    private fun init() {

        with(binding) {
            saveButton.setOnClickListener {
                val params = SaveUserNameParam(etPreference.text.toString())
                val result = saveUserNameUseCase.execute(params)
                prefText.text = "Save result: $result"
            }
            getButton.setOnClickListener {
                val userName = getUserNameUseCase.execute()
                prefText.text = userName.firstName + userName.lastName
            }
        }
    }
}