package com.example.studentapp.network.entity

data class Details(
    val parentId: Int,
    val subject: String,
    val form: String,
    val teacherName: String,
    val department: String,
    val studyDetailsList: List<StudyDetails>,
)