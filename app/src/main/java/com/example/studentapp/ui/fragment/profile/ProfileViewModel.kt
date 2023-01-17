package com.example.studentapp.ui.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.domain.entity.Profile
import com.example.studentapp.ui.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel : ViewModel() {
    val profile = MutableLiveData<Profile>()

    fun getProfile() {
        CoroutineScope(Dispatchers.IO).launch {
            val id = App.get().repository.getUserId()
            App.get().repository.getProfileById(id)?.let {
                withContext(Dispatchers.Main) {
                    profile.value = it
                }
            }
        }
    }

    fun clearDB() {
        CoroutineScope(Dispatchers.IO).launch { App.get().repository.clearDB() }
    }
}