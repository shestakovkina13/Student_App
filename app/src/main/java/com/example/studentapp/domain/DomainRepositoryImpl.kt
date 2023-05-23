package com.example.studentapp.domain

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.studentapp.domain.entity.User
import com.example.studentapp.ui.App
import com.google.gson.Gson


class DomainRepositoryImpl : DomainRepository {

    override fun setUser(user: User) {
        preferences.edit().putString(USER, gson.toJson(user)).apply()
    }

    override fun getUser(): User =
        preferences.getString(USER, "")?.let { gson.fromJson(it, User::class.java) } ?: User()


    override suspend fun clearDB() {
        preferences.edit().clear().apply()
    }

    companion object {
        private const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        private const val USER = "USER"

        private val gson = Gson()

        private val masterKey = MasterKey.Builder(App.get(), MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        private val preferences = EncryptedSharedPreferences.create(
            App.get(),
            SHARED_PREFERENCES,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
        )
    }
}