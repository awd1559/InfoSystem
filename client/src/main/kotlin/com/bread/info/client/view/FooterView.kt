package com.bread.info.client.view

import javafx.geometry.Pos
import javafx.scene.layout.Priority
import tornadofx.*

class FooterView : View("My View") {
    override val root = hbox {
        alignment = Pos.CENTER

        label("Personal Info System, 2017")
    }
}
