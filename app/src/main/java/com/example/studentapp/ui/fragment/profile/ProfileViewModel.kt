package com.example.studentapp.ui.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.domain.entity.Profile
import com.example.studentapp.ui.App

class ProfileViewModel : ViewModel() {
    val profile = MutableLiveData<Profile>()

    fun getProfile() {
        val id = App.get().repository.getUserId()
        App.get().repository.getProfileById(id)?.let { profile.value = it }
    }

    fun clearDB() {
        App.get().repository.clearDB()
    }
}