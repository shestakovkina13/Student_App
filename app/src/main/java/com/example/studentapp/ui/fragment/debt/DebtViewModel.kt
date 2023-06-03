package com.example.studentapp.ui.fragment.debt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.ui.App
import com.example.studentapp.ui.entity.StudyItem
import com.example.studentapp.utils.mapStudyItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DebtViewModel : ViewModel() {

    val studyList = MutableLiveData<List<StudyItem>>()
//Coroutine для управления асинхронными задачами, которые иначе могут блокировать основной поток и приводить к зависанию UI приложения
    fun getStudyList() {
        CoroutineScope(Dispatchers.IO).launch {
            val list = mapStudyItems(App.get().networkRepository.getDebtList())
            withContext(Dispatchers.Main) {
                studyList.value = list
            }
        }
    }
}