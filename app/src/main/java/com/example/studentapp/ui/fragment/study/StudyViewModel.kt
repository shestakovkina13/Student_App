package com.example.studentapp.ui.fragment.study

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.domain.entity.Study
import com.example.studentapp.ui.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudyViewModel : ViewModel() {

    val studyList = MutableLiveData<List<Study>>()

    fun getStudyList() {
        CoroutineScope(Dispatchers.IO).launch {
            val userId = App.get().repository.getUserId()
            val list = App.get().repository.getStudyList(userId)
            withContext(Dispatchers.Main) {
                studyList.value = list
            }
        }
    }
}