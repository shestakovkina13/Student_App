package com.example.studentapp.network

import com.example.studentapp.domain.entity.User
import com.example.studentapp.network.entity.Details
import com.example.studentapp.network.entity.Profile
import com.example.studentapp.network.entity.Study

interface NetworkRepository {

    suspend fun getProfileByUser(user: User): Profile?

    suspend fun getStudyList(): List<Study>

    suspend fun getDebtList(): List<Study>

    suspend fun getDetails(id: Int): Details?
}