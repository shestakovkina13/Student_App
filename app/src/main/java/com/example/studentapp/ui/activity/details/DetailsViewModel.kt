package com.example.studentapp.ui.activity.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.domain.entity.Details
import com.example.studentapp.ui.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel : ViewModel() {
    val details = MutableLiveData<Details>()

    fun getDetails(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            App.get().repository.getDetails(id)?.let {
                withContext(Dispatchers.Main) {
                    details.value = it
                }
            }
        }
    }
}