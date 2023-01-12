package com.example.studentapp.ui.activity.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.domain.entity.Details
import com.example.studentapp.ui.App

class DetailsViewModel : ViewModel() {
    val details = MutableLiveData<Details>()

    fun getDetails(id: Int) {
        App.get().repository.getDetails(id)?.let {
            details.value = it
        }
    }
}