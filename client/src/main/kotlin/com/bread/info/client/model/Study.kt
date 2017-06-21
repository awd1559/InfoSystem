package com.bread.info.client.model

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.util.*

class Study(category: StudyCategory, title: String) {
    val id = UUID.randomUUID()

    val titleProperty = SimpleStringProperty(title)
    var title by titleProperty

    val descriptionProperty = SimpleStringProperty()
    var description by descriptionProperty

    val categoryProperty = SimpleObjectProperty<StudyCategory>(category)
    var category by categoryProperty

    override fun toString(): String {
        return this.title
    }
}

class StudyModel : ItemViewModel<Study>() {
    val title = bind { SimpleStringProperty(item?.title) }
    val description = bind { SimpleStringProperty(item?.description) }
    val category = bind { SimpleObjectProperty<StudyCategory>(item?.category) }
}