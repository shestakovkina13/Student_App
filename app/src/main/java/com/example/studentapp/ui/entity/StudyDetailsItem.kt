package com.example.studentapp.ui.entity

import com.example.studentapp.R

data class StudyDetailsItem(
    val week: Int,
    val score: Int,
    val maxScore: Int,
    val subject: String,
    val description: String = "",
    val scoreColor: Int = when {
        score.toFloat() / maxScore * 100 < 20 -> R.color.red
        score.toFloat() / maxScore * 100 < 40 -> R.color.orange
        score.toFloat() / maxScore * 100 < 60 -> R.color.yellow
        score.toFloat() / maxScore * 100 < 80 -> R.color.light_green
        else -> R.color.green
    }
)