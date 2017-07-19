package com.bread.info.client.view

import javafx.geometry.Insets
import tornadofx.*

class MainView : View("My Personal InfoSystem Client") {

    override val root = borderpane {
        minHeight = 600.0
        minWidth = 800.0
        borderpaneConstraints {
            margin = Insets(10.0, 5.0, 10.0, 5.0)
        }
    }

    val tabview = TabView()
    val menuview = MenuView(tabview.root)

    init {
        with(root) {
            top = menuview.root
            center = tabview.root
            bottom = FooterView().root
        }
    }
}