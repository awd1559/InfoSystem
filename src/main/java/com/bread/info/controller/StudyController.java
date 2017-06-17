package com.bread.info.controller;

import com.bread.info.models.Study;
import com.bread.info.models.StudyCategory;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import java.util.List;


@ViewController(value = "/fxml/view/StudyView.fxml", title = "Study")
public class StudyController {

    @FXML
    private JFXButton btnNewCategory;
    @FXML
    private JFXButton btnDelCategory;
    @FXML
    private JFXListView<StudyCategory> listCategory;

    @FXML
    private JFXButton btnNewStudy;
    @FXML
    private JFXListView<Study> listStudy;

    private StudyCategory currentCategory = null;
    private Study currentStudy = null;

    @PostConstruct
    public void init() {
        initStudyCategoryList();
        setupButtons();

    }


    private void initStudyCategoryList(){

        List<StudyCategory> result = StudyCategory.find.all();

        listCategory.setItems(FXCollections.observableList(result));
        listCategory.setCellFactory(new Callback<ListView<StudyCategory>, ListCell<StudyCategory>>() {
            @Override
            public ListCell<StudyCategory> call(ListView<StudyCategory> listView) {
                return new StudyCategoryCell();
            }
        });

        listCategory.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listCategory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StudyCategory>() {
            @Override
            public void changed(ObservableValue<? extends StudyCategory> observable, StudyCategory oldValue, StudyCategory newValue) {
                currentCategory = newValue;
                switchListStudyToCurrentCategory(newValue);
            }
        });

        listCategory.getSelectionModel().selectFirst();
    }

    private void switchListStudyToCurrentCategory(StudyCategory category) {
        List<Study> result = Study.find.where().category.equalTo(category).findList();
        listStudy.setCellFactory(new Callback<ListView<Study>, ListCell<Study>>() {
            @Override
            public ListCell<Study> call(ListView<Study> study) {
                return new StudyCell();
            }
        });
        listStudy.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Study>() {
            @Override
            public void changed(ObservableValue<? extends Study> observable, Study oldValue, Study newValue) {
                currentStudy = newValue;

                //TODO:click study item
                //change to study detail controller

            }
        });
    }

    static class StudyCategoryCell extends ListCell<StudyCategory> {
        @Override
        protected void updateItem(StudyCategory item, boolean empty) {
            super.updateItem(item, empty);
            if(empty) {
                setText(null);
                setGraphic(null);
            } else {
                setText(null);

                Label subject = new Label(item.getSubject());
                subject.setFont(new Font(15));
                subject.setTextFill(Color.valueOf("#e82417"));
                setGraphic(subject);
            }

        }
    }

    static class StudyCell extends ListCell<Study> {
        @Override
        protected void updateItem(Study item, boolean empty) {
            super.updateItem(item, empty);
            if(empty) {
                setText(null);
                setGraphic(null);
            } else {
                setText(null);

                VBox box = new VBox(5);
                Label title = new Label(item.getTitle());
                Label updated = new Label(item.getWhenUpdated().toString());
                updated.setOpacity(0.5);
                box.getChildren().add(title);
                box.getChildren().add(updated);
                setGraphic(box);
            }

        }
    }



    //button event
    private void setupButtons() {
        btnNewCategory.setOnMouseClicked(e -> {
            JFXDialog dialog = new JFXDialog();
        });
    }
}
