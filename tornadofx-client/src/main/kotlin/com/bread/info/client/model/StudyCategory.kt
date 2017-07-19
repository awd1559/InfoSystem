package com.bread.info.client.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.util.*
import javax.json.JsonObject

class StudyCategory : JsonModel {
    var id by property<UUID>()
    fun idProperty() = getProperty(StudyCategory::id)

    var subject by property<String>()
    fun subjectProperty() = getProperty(StudyCategory::subject)

    override fun updateModel(json: JsonObject) {
        with(json) {
            id = uuid("id")
            subject = string("subject")
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("id", id)
            add("subject", subject)
        }
    }
}

class StudyCategoryModel : ItemViewModel<StudyCategory>() {
    val subject = bind { SimpleStringProperty(item?.subject) }
}