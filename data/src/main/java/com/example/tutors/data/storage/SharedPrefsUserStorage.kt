package com.example.tutors.data.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.tutors.domain.models.SaveUserNameParam
import com.example.tutors.domain.models.UserName

const val SHARED_PREFS_TAG = "SHARED_PREFS_TAG"
const val FIRST_NAME_TAG = "FIRST_NAME_TAG"
const val LAST_NAME_TAG = "LAST_NAME_TAG"
const val DEF_NAME = "defName"

class SharedPrefsUserStorage(context: Context): UserStorage {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREFS_TAG, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit()
            .putString(FIRST_NAME_TAG, user.firstName)
            .putString(LAST_NAME_TAG, user.lastName)
            .apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(FIRST_NAME_TAG, DEF_NAME)?: DEF_NAME
        val lastName = sharedPreferences.getString(LAST_NAME_TAG, DEF_NAME)?: DEF_NAME
        return User(firstName, lastName)
    }
}