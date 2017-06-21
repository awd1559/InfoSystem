package com.bread.info.client.view

import com.bread.info.client.view.coding.CodingMain
import com.bread.info.client.view.company.CompanyMain
import com.bread.info.client.view.note.NoteMain
import com.bread.info.client.view.study.StudyMain
import javafx.application.Platform
import javafx.scene.control.MenuBar
import javafx.scene.control.TabPane
import javafx.scene.layout.Priority
import tornadofx.*

class MenuView(tabPane: TabPane) : View("My Menu") {
    var tabpane = tabPane

    override val root = menubar {
        hgrow = Priority.ALWAYS

        menu("File") {
            item("Setting", "Ctrl+,")
            separator()
            item("Exit", "Ctrl+Q") {
                action {
                    Platform.exit()
                }
            }
        }

        menu("View") {
            item("Study", "Ctrl+0") {
                action {
                    tabpane.selectionModel.select(0)
                }
            }
            item("Note", "Ctrl+1") {
                action {
                    tabpane.selectionModel.select(1)
                }
            }
            item("开源", "Ctrl+2") {
                action {
                    tabpane.selectionModel.select(2)
                }
            }
            item("公司", "Ctrl+3") {
                action {
                    tabpane.selectionModel.select(3)
                }
            }
        }

        menu("Edit")
        menu("Help")
    }
}
