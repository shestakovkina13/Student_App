package com.example.studentapp.domain

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.studentapp.domain.entity.Profile
import com.example.studentapp.domain.entity.Study
import com.example.studentapp.ui.App


class RepositoryImpl : Repository {

    override suspend fun getStudyList(id: Int): List<Study> = Database.getStudyListById(id)

    override suspend fun getDebtList(id: Int): List<Study> = Database.getDebtListById(id)

    override suspend fun getProfileById(id: Int): Profile? = Database.getProfileById(id)

    override suspend fun getDetails(id: Int) = Database.getDetailsByStudyId(id)

    override suspend fun setUserId(id: Int) {
        preferences.edit().putInt(ID, id).apply()
    }

    override suspend fun getUserId() = preferences.getInt(ID, -1)

    override suspend fun clearDB() {
        preferences.edit().clear().apply()
    }

    companion object {
        private const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        private const val ID = "ID"
        var masterKey = MasterKey.Builder(App.get(), MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        val preferences = EncryptedSharedPreferences.create(
            App.get(),
            SHARED_PREFERENCES,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
        )
    }
}