package com.example.studentapp.ui.entity
//модель данных
import com.example.studentapp.R

data class StudyItem(
    val id: Int,
    val score: Int,
    val subject: String,
    val type: String,
    val userId: Int,
    val color: Int = when {
        score < 20 -> R.color.red
        score < 40 -> R.color.orange
        score < 60 -> R.color.yellow
        score < 80 -> R.color.light_green
        else -> R.color.green
    }
)