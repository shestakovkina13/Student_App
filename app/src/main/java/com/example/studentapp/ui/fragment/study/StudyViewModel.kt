package com.example.studentapp.ui.fragment.study

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.ui.App
import com.example.studentapp.ui.entity.StudyItem
import com.example.studentapp.utils.mapStudyItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudyViewModel : ViewModel() {

    val studyList = MutableLiveData<List<StudyItem>>()
//Coroutine - вызов отличного потока, используется многопоточность для быстродействия, для корректной работы интерфейса
    //Dispatchers определяет какой поток или какие потоки будут использоваться для выполнения Coroutine
    fun getStudyList() {
        CoroutineScope(Dispatchers.IO).launch {
            val list = mapStudyItems(App.get().networkRepository.getStudyList())
            withContext(Dispatchers.Main) {
                studyList.value = list
            }
        }
    }
}