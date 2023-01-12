package com.example.studentapp.ui.fragment.study

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.domain.entity.Study
import com.example.studentapp.ui.App

class StudyViewModel : ViewModel() {

    val studyList = MutableLiveData<List<Study>>()

    fun getStudyList() {
        val userId = App.get().repository.getUserId()
        studyList.value = App.get().repository.getStudyList(userId)
    }
}