package com.example.studentapp.network

import com.example.studentapp.BuildConfig
import com.example.studentapp.domain.entity.User
import com.example.studentapp.network.entity.Profile
import com.example.studentapp.network.entity.Study
import com.example.studentapp.ui.App
import com.google.gson.GsonBuilder
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkRepositoryImpl : NetworkRepository {
    //suspend означает, что функция должна запускаться внутри coroutine, чтобы не замедлять работу интерфейса
    //override - для переопределения свойства
    override suspend fun getProfileByUser(user: User): Profile? {
        val response = remoteService.getProfileById(Credentials.basic(user.login, user.password))
        return response.body()
    }

    override suspend fun getStudyList(): List<Study> = remoteService.getStudyList()

    override suspend fun getDebtList(): List<Study> = remoteService.getDebtList()

    override suspend fun getDetails(id: Int) = remoteService.getDetailsByStudyId(id)

    companion object {
        private val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) BODY else NONE
        }

        private val token = Interceptor { chain ->
            val user = App.get().domainRepository.getUser()
            val credentials = user?.let { Credentials.basic(user.login, user.password) } ?: ""
            val original = chain.request()
            val request = original.newBuilder()
                .header("Authorization", credentials)
                .header("User-Agent", "Mozilla/5.0")
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        }

        private val client = OkHttpClient.Builder()
            .addNetworkInterceptor(logging)
            .addInterceptor(token)
            .build()
//за счёт Retrofit интерфейсы API превращаются в вызываемые объекты, считается безопасным клиентом http для Android
        private val remoteService: RemoteService = Retrofit.Builder()
            .baseUrl("http://o9772829.beget.tech/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())) //добавление конвертера
            .build()
            .create(RemoteService::class.java)
    }
}