package org.example.learning.components.uibuilders;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Arrays;
import java.util.List;

public class ControlBuilder {
    public static Node buildFontCommands() {
        ScrollPane scrollPane = (ScrollPane) BuildContainer();
        VBox vBox = (VBox) scrollPane.getContent();
        vBox.setPadding(new Insets(8));

        // Font header label
        Label label = new Label("Font");
        label.getStyleClass().add("bold");
        label.getStyleClass().add("font-medium");

        // System Font list comobo box
        Font defaultFont = Font.getDefault();
        List fonts = Font.getFontNames();

        ComboBox<String> fontComboBox = new ComboBox(FXCollections.observableArrayList(fonts));
        fontComboBox.getSelectionModel().select(defaultFont.getName());

        // Grid selection
        GridPane gridPane = new GridPane();
        gridPane.setVgap(8);
        gridPane.setHgap(8);

        // Font weight combo box
        ComboBox<String> fontWeightComboBox = new ComboBox<>();
        fontWeightComboBox.getItems().addAll(
                "Thin",
                "Extra Light",
                "Light",
                "Regular",
                "Medium",
                "Semi Bold",
                "Bold",
                "Extra Bold",
                "Black"
        );
        fontWeightComboBox.getSelectionModel().select("Regular");

        ComboBox<String> fontSizeComboBox = new ComboBox<>();
        fontSizeComboBox.setEditable(true);
        fontSizeComboBox.getItems().addAll(
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "20",
                "24",
                "32",
                "36",
                "40",
                "48",
                "64",
                "96",
                "128"
        );
        fontSizeComboBox.getSelectionModel().select("12");

        gridPane.add(fontWeightComboBox, 0, 0);
        gridPane.add(fontSizeComboBox, 0, 1);


        vBox.getChildren().addAll(label, fontComboBox, gridPane);
        vBox.setSpacing(8);

        return scrollPane;

    }

    public static Node BuildContainer() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setOnMousePressed(Event::consume);
        scrollPane.getStyleClass().add("background-light");

        VBox vBox = new VBox();
        vBox.setOnMousePressed(Event::consume);
        vBox.setPrefWidth(180);


        scrollPane.setContent(vBox);

        return scrollPane;
    }
}
