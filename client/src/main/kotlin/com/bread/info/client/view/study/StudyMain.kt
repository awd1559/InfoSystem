package com.bread.info.client.view.study

import com.bread.info.client.controller.Mock
import com.bread.info.client.model.StudyCategoryModel
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import tornadofx.*

class StudyMain : View("My study view") {
    val controller : Mock by inject()
    val selectedCategory = StudyCategoryModel()

    override val root = hbox {
        padding = Insets(10.0, 5.0, 10.0, 5.0)

        listview(controller.studycategories) {
            isEditable = true
            cellFragment(StudyCategoryItem::class)
        }.bindSelected(selectedCategory)


        listview(controller.studies) {
            padding = Insets(5.0, 0.0, 0.0, 5.0)
            hgrow = Priority.ALWAYS

            cellFragment(StudyItem::class)
        }.pagination(controller.studies.count()/2, 0) {
            alignment = Pos.BOTTOM_CENTER
            hgrow = Priority.ALWAYS
            vgrow = Priority.ALWAYS
        }

    }

    init {
        selectedCategory.itemProperty.addListener { _, _, new ->
            controller.getStudyList(new)

//            page.pageCount = controller.studies.count()/2
        }
    }
}
