package com.bread.info.client.model

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.util.*

class StudyCategory(subject:String) {
    val id = UUID.randomUUID()

    val subjectProperty = SimpleStringProperty(subject)
    var subject by subjectProperty


}
class StudyCategoryModel : ItemViewModel<StudyCategory>() {
    val subject = bind { SimpleStringProperty(item?.subject) }
}