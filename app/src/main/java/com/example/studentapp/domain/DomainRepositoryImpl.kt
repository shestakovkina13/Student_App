package com.example.studentapp.domain

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.studentapp.domain.entity.User
import com.example.studentapp.ui.App
import com.google.gson.Gson

//имплементация интерфейса (позволяет менять один слой проекта, не задевая других)
class DomainRepositoryImpl : DomainRepository {

    //override - для переопределения свойства
    override fun setUser(user: User) {
        preferences.edit().putString(USER, gson.toJson(user)).apply()
    }

    override fun getUser(): User? =
        preferences.getString(USER, "")?.let { gson.fromJson(it, User::class.java) }

//suspend означает, что функция должна запускаться внутри coroutine, чтобы не замедлять работу интерфейса
    override suspend fun clearDB() {
        preferences.edit().clear().apply()
    }

    companion object {
        private const val SHARED_PREFERENCES = "SHARED_PREFERENCES"
        private const val USER = "USER"

        private val gson = Gson()

        private val masterKey = MasterKey.Builder(App.get(), MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM) //AES256 - симметричный алгоритм блочного шифрования с помощью 256битного ключа
            .build()
        private val preferences = EncryptedSharedPreferences.create(
            App.get(),
            SHARED_PREFERENCES,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
            //AES-GCM-SIV: одноразовое аутентифицированное шифрование, защищенное от неправильного использованиям
        )
    }
}