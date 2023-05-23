package com.example.studentapp.network.entity

import com.example.studentapp.R

data class StudyDetails(
    val week: Int,
    val score: Int,
    val maxScore: Int,
    val subject: String,
    val description: String = "",
)