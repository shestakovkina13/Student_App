package com.example.studentapp.domain

import android.content.Context
import android.content.SharedPreferences
import com.example.studentapp.domain.entity.Profile
import com.example.studentapp.domain.entity.Study
import com.example.studentapp.ui.App

class RepositoryImpl : Repository {

    override fun getStudyList(id: Int): List<Study> = Database.getStudyListById(id)

    override fun getDebtList(id: Int): List<Study> = Database.getDebtListById(id)

    override fun getProfileById(id: Int): Profile? = Database.getProfileById(id)

    override fun getDetails(id: Int) = Database.getDetailsByStudyId(id)

    override fun setUserId(id: Int) {
        preferences.edit().putInt(ID, id).apply()
    }

    override fun getUserId() = preferences.getInt(ID, -1)

    override fun clearDB() {
        preferences.edit().clear().apply()
    }

    companion object {
        private const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        private const val ID = "ID"
        val preferences: SharedPreferences =
            App.get().getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }
}