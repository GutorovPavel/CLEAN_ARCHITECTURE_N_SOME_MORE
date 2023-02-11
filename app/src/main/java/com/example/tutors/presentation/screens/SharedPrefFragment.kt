package com.example.tutors.presentation.screens

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tutors.APP
import com.example.tutors.PREF_TEXT
import com.example.tutors.databinding.FragmentSharedPrefBinding

class SharedPrefFragment : Fragment() {

    lateinit var binding: FragmentSharedPrefBinding

    private val preferenceListener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
        if (key == PREF_TEXT) {
            binding.prefText.text = APP.preferences.getString(key, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSharedPrefBinding.inflate(layoutInflater, container, false)
        init()

        return binding.root
    }

    private fun init() {

        val value = APP.preferences.getString(PREF_TEXT,"")

        binding.etPreference.setText(value)
        binding.prefText.text = value
        binding.saveButton.setOnClickListener {
            APP.preferences.edit()
                .putString(PREF_TEXT, binding.etPreference.text.toString())
                .apply()
        }

        APP.preferences.registerOnSharedPreferenceChangeListener(preferenceListener)
    }
}