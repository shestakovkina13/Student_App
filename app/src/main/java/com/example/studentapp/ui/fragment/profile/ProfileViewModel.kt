package com.example.studentapp.ui.fragment.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.ui.App
import com.example.studentapp.ui.entity.ProfileItem
import com.example.studentapp.utils.mapProfile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel : ViewModel() {
    val profile = MutableLiveData<ProfileItem>()
//Coroutine для управления асинхронными задачами, которые иначе могут блокировать основной поток и приводить к зависанию UI приложения
    //Dispatchers определяет какой поток или какие потоки будут использоваться для выполнения Coroutine
    fun getProfile() {
        CoroutineScope(Dispatchers.IO).launch {
            val user = App.get().domainRepository.getUser()
            if (user != null) {
                App.get().networkRepository.getProfileByUser(user)?.let {
                    withContext(Dispatchers.Main) {
                        profile.value = mapProfile(it)
                    }
                }
            }
        }
    }

    fun clearDB() {
        CoroutineScope(Dispatchers.IO).launch { App.get().domainRepository.clearDB() }
    }
}