package com.example.studentapp.ui.activity.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
            val id = App.get().repository.getUserId()
            val profile = App.get().repository.getProfileById(id)
            withContext(Dispatchers.Main) {
                profileExist.value = profile != null
            }
        }
    }

    fun setId(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val profile = App.get().repository.getProfileById(id)
            if (profile != null) {
                App.get().repository.setUserId(id)
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