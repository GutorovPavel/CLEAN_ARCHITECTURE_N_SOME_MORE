package com.example.tutors.presentation.screens.CleanArchitecture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tutors.APP
import com.example.tutors.data.repository.UserRepositoryImpl
import com.example.tutors.data.storage.SharedPrefsUserStorage
import com.example.tutors.databinding.FragmentCleanArchitectureBinding
import com.example.tutors.domain.models.SaveUserNameParam
import com.example.tutors.domain.usecases.GetUserNameUseCase
import com.example.tutors.domain.usecases.SaveUserNameUseCase
import org.koin.androidx.viewmodel.ext.android.viewModel

class CleanArchitectureFragment : Fragment() {

    lateinit var binding: FragmentCleanArchitectureBinding
    private val vm by viewModel<CleanArchitectureViewModel>()

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
            vm.text.observe(viewLifecycleOwner) {
                prefText.text = it
            }
            saveButton.setOnClickListener {
                vm.save(etPreference.text.toString())
            }
            getButton.setOnClickListener {
                vm.load()
            }
        }
    }
}