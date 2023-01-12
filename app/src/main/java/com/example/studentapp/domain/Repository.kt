package com.example.studentapp.domain

import com.example.studentapp.domain.entity.Profile
import com.example.studentapp.domain.entity.Study

class Repository {
    fun getStudyList(): List<Study> = listOf(
        Study(5, "Subject", "Type"),
        Study(10, "Subject", "Type"),
        Study(20, "Subject", "Type"),
        Study(30, "Subject", "Type"),
        Study(40, "Subject", "Type"),
        Study(50, "Subject", "Type"),
        Study(60, "Subject", "Type"),
        Study(70, "Subject", "Type"),
        Study(80, "Subject", "Type"),
        Study(90, "Subject", "Type"),
        Study(100, "Subject", "Type"),
    )

    fun getDebtList(): List<Study> = listOf()

    fun getProfile(): Profile =
        Profile(3, "Shestakova Alina Andreevna", "Group - 44", 234234)
}