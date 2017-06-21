package com.bread.info.client.view

import com.bread.info.client.view.coding.CodingMain
import com.bread.info.client.view.company.CompanyMain
import com.bread.info.client.view.note.NoteMain
import com.bread.info.client.view.study.StudyMain
import javafx.geometry.Insets
import javafx.scene.control.TabPane
import tornadofx.*

class TabView : View("My top tab") {
    override val root = tabpane {
        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE


        tab("study") {
            this += StudyMain()
        }

        tab("Note") {
            this += NoteMain()
        }

        tab("开源") {
            this += CodingMain()
        }

        tab("公司") {
            this += CompanyMain()
        }

    }
}
