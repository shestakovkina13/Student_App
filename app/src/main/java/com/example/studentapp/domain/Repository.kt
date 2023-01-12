package com.example.studentapp.domain

import android.content.Context
import android.content.SharedPreferences
import com.example.studentapp.domain.entity.Profile
import com.example.studentapp.domain.entity.Study
import com.example.studentapp.ui.App

class Repository {
    fun getStudyList(id: Int): List<Study> = Database.getStudyListById(id)

    fun getDebtList(id: Int): List<Study> = Database.getDebtListById(id)

    fun getProfileById(id: Int): Profile? = Database.getProfileById(id)

    fun getDetails(id: Int) = Database.getDetailsByStudyId(id)

    fun setUserId(id: Int) {
        preferences.edit().putInt(ID, id).apply()
    }

    fun getUserId() = preferences.getInt(ID, -1)

    fun clearDB() {
        preferences.edit().clear().apply()
    }

    companion object {
        private const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        private const val ID = "ID"
        val preferences: SharedPreferences =
            App.get().getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }
}