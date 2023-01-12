package com.example.studentapp.ui

import android.app.Application
import com.example.studentapp.domain.Repository

class App : Application() {

    val repository: Repository = Repository()

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        private var application: App? = null
        fun get(): App = application!!
    }
}