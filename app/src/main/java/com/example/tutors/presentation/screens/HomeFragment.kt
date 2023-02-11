package com.example.tutors.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tutors.APP
import com.example.tutors.R
import com.example.tutors.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        init()

        return binding.root
    }

    private fun init() {

        with(binding) {
            buttonSharedPreferences.setOnClickListener {
                APP.navController.navigate(R.id.action_homeFragment_to_sharedPrefFragment)
            }
            buttonCleanArchitecture.setOnClickListener {
                APP.navController.navigate(R.id.action_homeFragment_to_cleanArchitectureFragment)
            }
        }
    }
}