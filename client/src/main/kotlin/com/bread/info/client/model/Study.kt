package com.bread.info.client.model

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.util.*
import javax.json.JsonObject

class Study : JsonModel {
    var id by property<UUID>()
    fun idProperty() = getProperty(Study::id)

    var title by property<String>()
    fun titleProperty() = getProperty(Study::title)

    var description by property<String>()
    fun descriptionProperty() = getProperty(Study::description)

    var categoryid by property<UUID>()
    fun categoryidProperty() = getProperty(Study::categoryid)

    override fun updateModel(json: JsonObject) {
        with(json) {
            id = uuid("id")
            title = string("title")
            description = string("description")
            categoryid = uuid("category_id")
        }
    }

    override fun toJSON(json: JsonBuilder) {
        with(json) {
            add("id", id)
            add("title", title)
            add("description", description)
        }
    }

    override fun toString(): String {
        return this.title
    }
}

class StudyModel : ItemViewModel<Study>() {
    val title = bind { SimpleStringProperty(item?.title) }
    val description = bind { SimpleStringProperty(item?.description) }
//    val categoryid = bind { <StudyCategory>(item?.category) }
}