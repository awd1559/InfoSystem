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
        studies.predicate = { it.category == category }
    }
    fun addStudy(study: Study) {
        studies.add(study)
    }
    fun removeStudy(study: Study) {
        studies.remove(study)
    }



    init {
        val linux = StudyCategory("Linux")
        val javafx = StudyCategory("JavaFX")
        val tornadofx = StudyCategory("tornadoFX")
        studycategories.add(linux)
        studycategories.add(javafx)
        studycategories.add(tornadofx)


        studies.add(Study(linux, "new linux 1"))
        studies.add(Study(linux, "new linux 2"))
        studies.add(Study(javafx, "new javafx 1"))
        studies.add(Study(javafx, "new javafx 2"))
        studies.add(Study(tornadofx, "new tornadofx 1"))
        studies.add(Study(tornadofx, "new tornadofx 2"))
        studies.add(Study(tornadofx, "new tornadofx 3"))
        studies.add(Study(tornadofx, "new tornadofx 4"))
    }
}