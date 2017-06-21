package com.bread.info.client.view.study

import com.bread.info.client.controller.Mock
import com.bread.info.client.model.StudyCategory
import com.bread.info.client.model.StudyCategoryModel
import javafx.scene.layout.Priority
import tornadofx.*

class StudyCategoryItem : ListCellFragment<StudyCategory>() {

    val category = StudyCategoryModel().bindTo(this)

    override val root = hbox {
        label(category.subject) {
            hgrow = Priority.ALWAYS
            useMaxSize = true
            removeWhen { editingProperty }
        }

        textfield(category.subject) {
            hgrow = Priority.ALWAYS
            removeWhen { editingProperty.not() }
            whenVisible { requestFocus() }
            action { commitEdit(item) }
        }
    }
}