package com.example.studentapp.network

import com.example.studentapp.network.entity.Details
import com.example.studentapp.network.entity.Profile
import com.example.studentapp.network.entity.Study
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("profile.php")
    suspend fun getProfileById(@Query("credentials") credentials: String): Response<Profile?>

    @GET("study.php")
    suspend fun getStudyList(): List<Study>

    @GET("debt.php")
    suspend fun getDebtList(): List<Study>

    @GET("details.php")
    suspend fun getDetailsByStudyId(@Query("id") id: Int): Details?
}