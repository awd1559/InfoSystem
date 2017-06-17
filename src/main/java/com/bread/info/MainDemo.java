package com.bread.info;

import com.jfoenix.controls.JFXDecorator;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.bread.info.controller.main.MainController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;


//@SpringBootApplication
public class MainDemo extends Application { //implements CommandLineRunner {

    @FXMLViewFlowContext
    private ViewFlowContext flowContext;

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(MainDemo.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);

        launch(args);
    }

    public void run(String... args) throws Exception {
//        testData();
        launch(args);
    }

//    @Autowired
//    private NoteService noteService;

    private void testData() {
//        Note note1 = new Note();
//        note1.setTitle("test1");
//        noteService.repository.save(note1);
//
//        Note note2 = new Note();
//        note2.setTitle("test2");
//        noteService.repository.save(note2);
//
//        Note note3 = new Note();
//        note3.setTitle("test3");
//        noteService.repository.save(note3);
//
//        Note note4 = new Note();
//        note4.setTitle("test4");
//        noteService.repository.save(note4);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Flow flow = new Flow(MainController.class);
        DefaultFlowContainer container = new DefaultFlowContainer();
        flowContext = new ViewFlowContext();
        flowContext.register("Stage", stage);
        flow.createHandler(flowContext).start(container);

        JFXDecorator decorator = new JFXDecorator(stage, container.getView());
        decorator.setCustomMaximize(true);

        Config config = ConfigFactory.load();
        int x = config.getInt("screen.x");
        int y = config.getInt("screen.y");
        int width = config.getInt("screen.width");
        int heigt = config.getInt("screen.height");
        boolean fullscreen = config.getBoolean("screen.fullscreen");
        if(fullscreen || width <= 0) {
            width = 800;
            heigt = 850;
        }

        Scene scene = new Scene(decorator, width, heigt);

        final ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.addAll(MainDemo.class.getResource("/css/jfoenix-fonts.css").toExternalForm(),
                           MainDemo.class.getResource("/css/jfoenix-design.css").toExternalForm(),
                           MainDemo.class.getResource("/css/jfoenix-main-demo.css").toExternalForm());

        stage.setScene(scene);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        if(scene.getWidth() > primaryScreenBounds.getWidth() || scene.getHeight() > primaryScreenBounds.getHeight()) {
            stage.setX(primaryScreenBounds.getMinX());
            stage.setY(primaryScreenBounds.getMinY());
            stage.setWidth(primaryScreenBounds.getWidth());
            stage.setHeight(primaryScreenBounds.getHeight());
        }
        stage.show();
        stage.setFullScreen(fullscreen);
    }

}
