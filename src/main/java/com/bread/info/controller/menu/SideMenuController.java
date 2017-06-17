package com.bread.info.controller.menu;

import com.bread.info.controller.*;
import com.jfoenix.controls.JFXListView;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

import javax.annotation.PostConstruct;
import java.util.Objects;

@ViewController(value = "/fxml/SideMenu.fxml", title = "Material Design Example")
public class SideMenuController {

    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    @ActionTrigger("study")
    private Label study;
    @FXML
    @ActionTrigger("note")
    private Label note;
    @FXML
    @ActionTrigger("software")
    private Label software;
    @FXML
    @ActionTrigger("opensource")
    private Label opensource;
    @FXML
    @ActionTrigger("company")
    private Label company;
//    @FXML
//    @ActionTrigger("listview")
//    private Label listview;
//    @FXML
//    @ActionTrigger("treetableview")
//    private Label treetableview;
//    @FXML
//    @ActionTrigger("progressbar")
//    private Label progressbar;
//    @FXML
//    @ActionTrigger("radiobutton")
//    private Label radiobutton;
//    @FXML
//    @ActionTrigger("slider")
//    private Label slider;
//    @FXML
//    @ActionTrigger("spinner")
//    private Label spinner;
//    @FXML
//    @ActionTrigger("textfield")
//    private Label textfield;
//    @FXML
//    @ActionTrigger("togglebutton")
//    private Label togglebutton;
//    @FXML
//    @ActionTrigger("popup")
//    private Label popup;
//    @FXML
//    @ActionTrigger("svgLoader")
//    private Label svgLoader;
//    @FXML
//    @ActionTrigger("pickers")
//    private Label pickers;
//    @FXML
//    @ActionTrigger("masonry")
//    private Label masonry;
//    @FXML
//    @ActionTrigger("scrollpane")
//    private Label scrollpane;
    @FXML
    private JFXListView<Label> sideList;

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {
        Objects.requireNonNull(context, "context");
        FlowHandler contentFlowHandler = (FlowHandler) context.getRegisteredObject("ContentFlowHandler");
        sideList.propagateMouseEventsToParent();
        sideList.getSelectionModel().selectedItemProperty().addListener((o, oldVal, newVal) -> {
            if (newVal != null) {
                try {
                    contentFlowHandler.handle(newVal.getId());
//                    JFXDrawer drawer = (JFXDrawer)context.getRegisteredObject("Drawer");
//                    drawer.close();
                } catch (VetoException exc) {
                    exc.printStackTrace();
                } catch (FlowException exc) {
                    exc.printStackTrace();
                }
            }
        });
        Flow contentFlow = (Flow) context.getRegisteredObject("ContentFlow");

        bindNodeToController(study, StudyController.class, contentFlow);
        bindNodeToController(note, NoteController.class, contentFlow);
        bindNodeToController(software, SoftwareController.class, contentFlow);
        bindNodeToController(opensource, CodingController.class, contentFlow);
        bindNodeToController(company, CompanyController.class, contentFlow);
    }

    private void bindNodeToController(Node node, Class<?> controllerClass, Flow flow) {
        flow.withGlobalLink(node.getId(), controllerClass);
    }

}
