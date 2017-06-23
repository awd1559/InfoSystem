package com.bread.info.client.controller

import com.bread.info.client.model.Coding
import com.bread.info.client.model.Study
import com.bread.info.client.model.StudyCategory
import tornadofx.*
import java.util.*

class Mock : Controller() {

    val codings = SortedFilteredList<Coding>()
    fun addCoding(coding: Coding) {
        codings.add(coding)
    }

    fun removeCoding(id:UUID) {
        codings.removeIf { it.id == id }
    }


    val studycategories = SortedFilteredList<StudyCategory>()
    fun addStudyCategory(studyCategory: StudyCategory) {
        studycategories.add(studyCategory)
    }
    fun removeStudyCategory(studyCategory: StudyCategory) {
        studycategories.remove(studyCategory)
    }

    val studies = SortedFilteredList<Study>()
    fun getStudyList(category: StudyCategory) {
        studies.predicate = { it.categoryid == category.id }
    }
    fun addStudy(study: Study) {
        studies.add(study)
    }
    fun removeStudy(study: Study) {
        studies.remove(study)
    }



    init {
        val linux = StudyCategory()
        linux.subject = "Linux"
        val javafx = StudyCategory()
        javafx.subject = "JavaFX"
        val tornadofx = StudyCategory()
        tornadofx.subject = "tornadoFX"
        studycategories.add(linux)
        studycategories.add(javafx)
        studycategories.add(tornadofx)


        val study1 = Study()
        study1.title = "new linux 1"
        study1.categoryid = linux.id
        studies.add(study1)
        val study2 = Study()
        study2.title = "new linux 2"
        study2.categoryid = linux.id
        studies.add(study2)

        val study3 = Study()
        study3.title = "new javafx 1"
        study3.categoryid = javafx.id
        studies.add(study3)
        val study4 = Study()
        study4.title = "new javafx 2"
        study4.categoryid = javafx.id
        studies.add(study4)

        val study5 = Study()
        study5.title = "new tornadofx 1"
        study5.categoryid = tornadofx.id
        studies.add(study5)
        val study6 = Study()
        study6.title = "new tornadofx 2"
        study6.categoryid = tornadofx.id
        studies.add(study6)
        val study7 = Study()
        study7.title = "new tornadofx 3"
        study7.categoryid = tornadofx.id
        studies.add(study7)
        val study8 = Study()
        study8.title = "new tornadofx 4"
        study8.categoryid = tornadofx.id
        studies.add(study8)

    }
}