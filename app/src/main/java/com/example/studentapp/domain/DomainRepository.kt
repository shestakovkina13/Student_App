package com.example.studentapp.domain

import com.example.studentapp.domain.entity.User

interface DomainRepository {

    fun setUser(user: User)

    fun getUser(): User?

    suspend fun clearDB()
}