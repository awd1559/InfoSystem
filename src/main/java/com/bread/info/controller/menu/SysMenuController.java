package com.bread.info.controller.menu;

import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.fxml.FXML;

public final class SysMenuController {
    @FXML
    private JFXListView<?> toolbarPopupList;

    // close application
    @FXML
    private void submit() {
        int index = toolbarPopupList.getSelectionModel().getSelectedIndex();
        switch (index){
            case 1:
                //setting menu item
                break;
                //exit menu item
            case 2:
                Platform.exit();
                break;
            default:
                break;
        }
    }
}
