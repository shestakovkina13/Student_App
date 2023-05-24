package com.example.studentapp.ui.activity.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.domain.entity.User
import com.example.studentapp.ui.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    val profileExist = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    fun checkProfileExist() {
        CoroutineScope(Dispatchers.IO).launch {
            val user = App.get().domainRepository.getUser()
            val profile = user?.let { App.get().networkRepository.getProfileByUser(user) }
            withContext(Dispatchers.Main) {
                profileExist.value = profile != null
            }
        }
    }

    fun setUser(login: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val user = User(login, password)
            val profile = App.get().networkRepository.getProfileByUser(user)
            if (profile != null) {
                App.get().domainRepository.setUser(user)
                withContext(Dispatchers.Main) {
                    profileExist.value = true
                }
            } else {
                withContext(Dispatchers.Main) {
                    message.value = "Wrong username"
                }
            }
        }
    }
}