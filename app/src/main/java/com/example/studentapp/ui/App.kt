package com.example.studentapp.ui

import android.app.Application
import com.example.studentapp.domain.DomainRepository
import com.example.studentapp.domain.DomainRepositoryImpl
import com.example.studentapp.network.NetworkRepository
import com.example.studentapp.network.NetworkRepositoryImpl

class App : Application() {

    val domainRepository: DomainRepository by lazy { DomainRepositoryImpl() }
    val networkRepository: NetworkRepository by lazy { NetworkRepositoryImpl() }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        private var application: App? = null
        fun get(): App = application!!
    }
}