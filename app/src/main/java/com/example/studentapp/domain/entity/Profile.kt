package com.example.studentapp.domain.entity

data class Profile(
    val username: String,
    val group: String,
    val id: Int,
    val semesterValue: Int = 3,
    val semesterProgress: Int = (semesterValue.toFloat() / 16 * 100).toInt(),
    val week: String = when {
        semesterValue % 4 == 1 -> "1st numerator"
        semesterValue % 4 == 2 -> "1st delimiter"
        semesterValue % 4 == 3 -> "2nd numerator"
        else -> "2nd delimiter"
    }
)