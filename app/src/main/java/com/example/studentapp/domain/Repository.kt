package com.example.studentapp.domain

import com.example.studentapp.domain.entity.Details
import com.example.studentapp.domain.entity.Profile
import com.example.studentapp.domain.entity.Study

interface Repository {

    fun getStudyList(id: Int): List<Study>

    fun getDebtList(id: Int): List<Study>

    fun getProfileById(id: Int): Profile?

    fun getDetails(id: Int): Details?

    fun setUserId(id: Int)

    fun getUserId(): Int

    fun clearDB()
}