package com.example.studentapp.ui

import android.app.Application
import com.example.studentapp.domain.DomainRepository
import com.example.studentapp.domain.DomainRepositoryImpl
import com.example.studentapp.network.NetworkRepository
import com.example.studentapp.network.NetworkRepositoryImpl
//app отвечает за ЖЦ приложения, чрез него доступ к Repository
class App : Application() {
//lazy - ленивая инициализация (происходит, когда объект будет вызван первый раз)
    val domainRepository: DomainRepository by lazy { DomainRepositoryImpl() }
    val networkRepository: NetworkRepository by lazy { NetworkRepositoryImpl() }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    //для создания аналогичных методов только уже в классе, для которого предполагается создание экземпляров
    companion object {
        private var application: App? = null
        fun get(): App = application!!
    }
}