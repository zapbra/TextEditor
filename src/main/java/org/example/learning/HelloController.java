package org.example.learning;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.example.learning.components.WindowBox;
import org.example.learning.components.glyph.DoublyLinkedList;
import org.example.learning.components.glyph.TextGlyph;
import org.example.learning.components.uibuilders.ControlBuilder;

import java.util.Arrays;

public class HelloController {
    String[] fontWeightArray = new String[]{"Thin", "Extra Light", "Light", "Regular", "Medium", "Semi Bold",
            "Bold", "Extra Bold", "Black"};
    Double[] fontSizes = new Double[]{10.0, 11.0, 12.0, 13.0, 14.0, 15.0,
            16.0, 20.0, 24.0, 32.0, 36.0, 40.0, 48.0, 64.0, 96.0, 128.0};
    /**
     * Text objects to be drawn on the screen
     */
    DoublyLinkedList textRowList = new DoublyLinkedList();
    /**
     * Current text which the user is typing into
     */
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
    ColorPicker colorPicker;


    @FXML
    public void initialize() {
        windowBox = new WindowBox(textAnchorPane, textRowList);

        // build combo boxes for selecting font styles
        fontComboBox.setItems(FXCollections.observableArrayList(Font.getFamilies()));
        fontComboBox.setValue(Font.getDefault().getName());

        fontWeightComboBox.setItems(FXCollections.observableArrayList(fontWeightArray));
        fontWeightComboBox.setValue("Regular");

        fontSizeComboBox.setItems(FXCollections.observableArrayList(fontSizes));
        fontSizeComboBox.setValue(12.0);

    }

    @FXML
    public void selectFont() {
        String font = fontComboBox.getValue();
        TextGlyph currentText = windowBox.getCurrentText();
        currentText.setFont(new Font(font, currentText.getFontSize()));
        System.out.println("current text");
        System.out.println(currentText.getText());

    }

    @FXML
    public void selectFontWeight() {
        String fontWeightString = fontWeightComboBox.getValue();
        TextGlyph currentText = windowBox.getCurrentText();
        FontWeight fontWeight = getFontWeight(fontWeightString);
        currentText.setFontWeight(fontWeight);
        currentText.setFont(Font.font(currentText.getFont().getName(), fontWeight, currentText.getFontSize()));
    }

    public static FontWeight getFontWeight(String fontWeight) {
        switch (fontWeight) {
            case "Thin":
                return FontWeight.THIN;
            case "Extra Light":
                return FontWeight.EXTRA_LIGHT;
            case "Light":
                return FontWeight.LIGHT;
            case "Regular":
                return FontWeight.NORMAL;
            case "Medium":
                return FontWeight.MEDIUM;
            case "Semi Bold":
                return FontWeight.SEMI_BOLD;
            case "Bold":
                return FontWeight.BOLD;
            case "Extra Bold":
                return FontWeight.EXTRA_BOLD;
            case "Black":
                return FontWeight.BLACK;
            default:
                return FontWeight.NORMAL;
        }
    }

    @FXML
    public void selectFontSize() {
        double fontSize = fontSizeComboBox.getValue();
        TextGlyph currentText = windowBox.getCurrentText();
        currentText.setFont(Font.font(currentText.getFont().getName(), currentText.getFontWeight(), fontSize));
    }

    @FXML
    public void selectFontColor() {
        Color selectedColor = colorPicker.getValue();
        TextGlyph currentText = windowBox.getCurrentText();
        currentText.getText().setFill(selectedColor);
        currentText.setFontColor(selectedColor);
    }


}