package com.example.studentapp.domain

import com.example.studentapp.domain.entity.Details
import com.example.studentapp.domain.entity.Profile
import com.example.studentapp.domain.entity.Study

interface Repository {

    suspend fun getStudyList(id: Int): List<Study>

    suspend fun getDebtList(id: Int): List<Study>

    suspend fun getProfileById(id: Int): Profile?

    suspend fun getDetails(id: Int): Details?

    suspend fun setUserId(id: Int)

    suspend fun getUserId(): Int

    suspend fun clearDB()
}