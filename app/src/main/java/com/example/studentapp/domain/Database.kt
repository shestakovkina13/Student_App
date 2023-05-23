package com.example.studentapp.domain

import com.example.studentapp.network.entity.Details
import com.example.studentapp.network.entity.Profile
import com.example.studentapp.network.entity.Study
import com.example.studentapp.network.entity.StudyDetails

@Suppress("MagicNumber")
object Database {

    private val profiles = listOf(
        Profile("Shestakova Alina Andreevna", "Group - 41", 111111),

        Profile("User 2", "Group - 42", 222222),

        Profile("User 3", "Group - 43", 333333),

        Profile("User 4", "Group - 44", 444444),

        Profile("User 5", "Group - 45", 555555),

        Profile("User 6", "Group - 46", 666666),

        Profile("User 7", "Group - 47", 777777),

        Profile("User 8", "Group - 48", 888888),

        Profile("User 9", "Group - 49", 999999),

        )

    private val studyList = listOf(
        Study(1, 5, "Subject", "Type", 111111),
        Study(2, 10, "Subject", "Type", 111111),
        Study(3, 20, "Subject", "Type", 111111),

        Study(1, 30, "Subject", "Type", 222222),

        Study(1, 40, "Subject", "Type", 333333),

        Study(1, 50, "Subject", "Type", 444444),

        Study(1, 60, "Subject", "Type", 555555),

        Study(1, 70, "Subject", "Type", 666666),

        Study(1, 80, "Subject", "Type", 777777),

        Study(1, 90, "Subject", "Type", 888888),

        Study(1, 100, "Subject", "Type", 999999),
    )

    private val debtList = listOf(
        Study(4, 5, "Subject", "Type", 222222),
        Study(5, 10, "Subject", "Type", 222222),

        Study(4, 20, "Subject", "Type", 333333),
        Study(5, 30, "Subject", "Type", 333333),

        Study(4, 40, "Subject", "Type", 444444),
        Study(4, 50, "Subject", "Type", 555555),
        Study(5, 60, "Subject", "Type", 555555),
        Study(6, 70, "Subject", "Type", 555555),
        Study(7, 80, "Subject", "Type", 555555),

        Study(4, 90, "Subject", "Type", 666666),

        Study(4, 100, "Subject", "Type", 888888),
    )

    private val details = listOf(
        Details(
            1, "Subject", "Exam", "Teacher 1", "Department name", listOf(
                StudyDetails(1, 2, 8, "Lecture", "Basic"),
                StudyDetails(2, 4, 8, "Lab", ""),
                StudyDetails(3, 6, 10, "Lab", ""),
            )
        ),
        Details(
            2, "Subject", "Differentiated credit", "Teacher 2", "Department name", listOf(
                StudyDetails(1, 2, 8, "Lab", ""),
                StudyDetails(2, 4, 8, "Lecture", "Basic"),
                StudyDetails(3, 6, 10, "Lab", ""),
            )
        ),
        Details(
            3, "Subject", "Exam", "Teacher 3", "Department name", listOf(
                StudyDetails(1, 2, 8, "Lab", ""),
                StudyDetails(2, 4, 8, "Lab", ""),
                StudyDetails(3, 6, 10, "Lecture", "Basic"),
            )
        ),
        Details(
            4, "Subject", "Differentiated credit", "Teacher 4", "Department name", listOf(
                StudyDetails(1, 2, 8, "Lecture", "Basic"),
                StudyDetails(2, 4, 8, "Lab", ""),
                StudyDetails(3, 6, 10, "Lab", ""),
            )
        ),
        Details(
            5, "Subject", "Exam", "Teacher 5", "Department name", listOf(
                StudyDetails(1, 2, 8, "Lab", ""),
                StudyDetails(2, 4, 8, "Lecture", "Basic"),
                StudyDetails(3, 6, 10, "Lab", ""),
            )
        ),
        Details(
            6, "Subject", "Differentiated credit", "Teacher 6", "Department name", listOf(
                StudyDetails(1, 2, 8, "Lecture", ""),
                StudyDetails(2, 4, 8, "Lab", ""),
                StudyDetails(3, 6, 10, "Lecture", ""),
            )
        ),
        Details(
            7, "Subject", "Exam", "Teacher 7", "Department name", listOf(
                StudyDetails(1, 2, 8, "Lecture", ""),
                StudyDetails(2, 4, 8, "Lecture", ""),
                StudyDetails(3, 6, 10, "Lab", ""),
            )
        ),
    )

    fun getStudyListById(id: Int) = studyList.filter { it.userId == id }

    fun getDebtListById(id: Int) = debtList.filter { it.userId == id }

    fun getProfileById(id: Int) = profiles.firstOrNull { it.id == id }

    fun getDetailsByStudyId(id: Int) = details.firstOrNull { it.parentId == id }
}
