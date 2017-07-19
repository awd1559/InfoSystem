package com.bread.info.client.controller

import com.bread.info.client.model.Study
import com.bread.info.client.model.StudyCategory
import com.bread.info.client.model.StudyCategoryModel
import com.bread.info.client.util.Constants.CN_SERVER_URL
import com.bread.info.client.util.Constants.URL_STUDY_CATEGORY_ADD
import com.bread.info.client.util.Constants.URL_STUDY_CATEGORY_LIST
import com.bread.info.client.util.Constants.URL_STUDY_CATEGORY_REMOVE
import com.bread.info.client.util.Constants.URL_STUDY_LIST
import javafx.collections.ObservableList
import tornadofx.*

class StudyController : Controller() {
    val api: Rest by inject()

    init {
        api.baseURI = config.string(CN_SERVER_URL, "http://127.0.0.1:8080")
    }

    fun getCategoryList() : ObservableList<StudyCategory> = api.get(URL_STUDY_CATEGORY_LIST).list().toModel()

    fun addCategory(category: StudyCategory) : Boolean {
        api.post(URL_STUDY_CATEGORY_ADD, category)
        return false
    }

    fun removeCategory(category: StudyCategory) : Boolean {
        api.post(URL_STUDY_CATEGORY_REMOVE, category)
        return false
    }

    fun getStudyList(category: StudyCategory?) : ObservableList<Study> = api.get(URL_STUDY_LIST+category?.id).list().toModel()

}
