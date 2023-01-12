package com.example.studentapp.ui.activity.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.ui.App

class LoginViewModel : ViewModel() {
    val profileExist = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    fun checkProfileExist() {
        val id = App.get().repository.getUserId()
        profileExist.value = App.get().repository.getProfileById(id) != null
    }

    fun setId(id: Int) {
        val profile = App.get().repository.getProfileById(id)
        if (profile != null) {
            App.get().repository.setUserId(id)
            profileExist.value = true
        } else {
            message.value = "Wrong username"
        }
    }
}