package org.example.learning;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.learning.components.WindowBox;
import org.example.learning.components.uibuilders.ControlBuilder;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        HBox root = fxmlLoader.load();
        stage.setTitle("Hello!");
        HelloController controller = (HelloController) fxmlLoader.getController();
//        WindowBox windowBox = new WindowBox();
//        ScrollPane commandBar = (ScrollPane) ControlBuilder.buildFontCommands();
//
//        root.getChildren().addAll(windowBox.getPane(), commandBar);


        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
        controller.runSceneFunctions(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}