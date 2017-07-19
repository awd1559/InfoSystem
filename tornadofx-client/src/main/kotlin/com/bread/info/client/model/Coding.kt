package com.bread.info.client.model

import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.util.*

class Coding(category:String, subcategory:String, tag:String, description:String) {
    val id = UUID.randomUUID()

    val categoryProperty = SimpleStringProperty(category)
    var category by categoryProperty

    val subcategoryProperty = SimpleStringProperty(subcategory)
    var subcategory by subcategoryProperty

    val tagProperty = SimpleStringProperty(tag)
    var tag by tagProperty

    val descriptionProperty = SimpleStringProperty(description)
    var description by descriptionProperty


}

class CodingModel : ItemViewModel<Coding>() {
    val category    = bind { SimpleStringProperty(item.category) }
    val subcategory = bind { SimpleStringProperty(item.subcategory) }
    val tag         = bind { SimpleStringProperty(item.tag) }
    val description = bind { SimpleStringProperty(item.description) }
}