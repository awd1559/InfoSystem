package com.bread.info.client.view.study

import com.bread.info.client.model.Study
import com.bread.info.client.model.StudyModel
import javafx.scene.layout.Priority
import tornadofx.*

class StudyItem : ListCellFragment<Study>() {
    val category = StudyModel().bindTo(this)

    override val root = hbox {
        label(category.title) {
            hgrow = Priority.ALWAYS
            useMaxSize = true
            removeWhen { editingProperty }
        }

        textfield(category.title) {
            hgrow = Priority.ALWAYS
            removeWhen { editingProperty.not() }
            whenVisible { requestFocus() }
            action { commitEdit(item) }
        }
    }
}