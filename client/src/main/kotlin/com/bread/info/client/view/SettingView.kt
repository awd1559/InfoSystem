package com.bread.info.client.view

import com.bread.info.client.util.Constants.CN_SERVER_URL
import javafx.beans.binding.BooleanExpression
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import tornadofx.*

class SettingView : View("Setting") {

    val server_url_property = SimpleStringProperty(this, CN_SERVER_URL, config.string(CN_SERVER_URL, "http://127.0.0.1:8080"))

    override val root = form {
        fieldset("服务端:") {
            field("url:") {
                textfield { bind(server_url_property) }
            }
        }
        button("保存") {
            action {
                config.set(CN_SERVER_URL to server_url_property)
                close()
            }
        }
    }
}