package com.example.studentapp.domain.entity

data class Details(
    val parentId: Int,
    val subject: String,
    val form: String,
    val teacherName: String,
    val department: String,
    val studyDetailsList: List<StudyDetails>
)