package com.example.studentapp.utils
//для преобразования данных из модели данных на сервере в модель данных для UI
import com.example.studentapp.network.entity.Profile
import com.example.studentapp.network.entity.Study
import com.example.studentapp.network.entity.StudyDetails
import com.example.studentapp.ui.entity.ProfileItem
import com.example.studentapp.ui.entity.StudyDetailsItem
import com.example.studentapp.ui.entity.StudyItem

fun mapStudyItems(studyList: List<Study>) = studyList.map {
    StudyItem(
        id = it.id,
        score = it.score,
        subject = it.subject,
        type = it.type,
        userId = it.userId,
    )
}

fun mapProfile(profile: Profile) = ProfileItem(
    username = profile.username,
    group = profile.group,
    id = profile.id,
)

fun mapStudyDetails(studyDetailsList: List<StudyDetails>) = studyDetailsList.map {
    StudyDetailsItem(
        week = it.week,
        score = it.score,
        maxScore = it.maxScore,
        subject = it.subject,
        description = it.description,
    )
}