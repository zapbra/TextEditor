package org.example.learning;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import org.example.learning.components.WindowBox;
import org.example.learning.components.uibuilders.ControlBuilder;

import java.util.Arrays;

public class HelloController {
    String[] fontWeightArray = new String[]{"Thin", "Extra Light", "Light", "Regular", "Medium", "Semi Bold",
            "Bold", "Extra Bold", "Black"};
    Double[] fontSizes = new Double[]{10.0, 11.0, 12.0, 13.0, 14.0, 15.0,
            16.0, 20.0, 24.0, 32.0, 36.0, 40.0, 48.0, 64.0, 96.0, 128.0};


    WindowBox windowBox;

    @FXML
    AnchorPane textAnchorPane;

    @FXML
    ComboBox<String> fontComboBox;

    @FXML
    ComboBox<String> fontWeightComboBox;

    @FXML
    ComboBox<Double> fontSizeComboBox;


    @FXML
    public void initialize() {
        windowBox = new WindowBox(textAnchorPane);

        // build combo boxes for selecting font styles
        fontComboBox.setItems(FXCollections.observableArrayList(Font.getFamilies()));
        fontComboBox.setValue(Font.getDefault().getName());

        fontWeightComboBox.setItems(FXCollections.observableArrayList(fontWeightArray));
        fontWeightComboBox.setValue("Regular");

        fontSizeComboBox.setItems(FXCollections.observableArrayList(fontSizes));
        fontSizeComboBox.setValue(12.0);

    }
}