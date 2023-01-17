package com.example.studentapp.domain.entity

import com.example.studentapp.R

data class Profile(
    val username: String,
    val group: String,
    val id: Int,
    val semesterValue: Int = 3,
    val semesterProgress: Int = (semesterValue.toFloat() / 16 * 100).toInt(),
    val week: Int = when {
        semesterValue % 4 == 1 -> R.string.first_numerator
        semesterValue % 4 == 2 -> R.string.first_delimiter
        semesterValue % 4 == 3 -> R.string.second_numerator
        else -> R.string.second_delimiter
    }
)