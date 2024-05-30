package org.example.learning.components.glyph;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class FontControlPanel implements ControlPanel {
    ComboBox<String> fontComboBox;
    String defaultFont;
    ComboBox<String> fontWeightComboBox;
    String defaultFontWeight;

    ComboBox<Double> fontSizeComboBox;
    double defaultFontSize;

    ColorPicker colorPicker;
    Color defaultColor;

    public FontControlPanel(ComboBox<String> fontComboBox, String defaultFont, ComboBox<String> fontWeightComboBox,
                            String defaultFontWeight, ComboBox<Double> fontSizeComboBox, double defaultFontSize,
                            ColorPicker colorPicker, Color defaultColor) {
        this.fontComboBox = fontComboBox;
        this.defaultFont = defaultFont;

        this.fontWeightComboBox = fontWeightComboBox;
        this.defaultFontWeight = defaultFontWeight;

        this.fontSizeComboBox = fontSizeComboBox;
        this.defaultFontSize = defaultFontSize;

        this.colorPicker = colorPicker;
        this.defaultColor = defaultColor;
    }

    @Override
    public void reset() {
        this.fontComboBox.setValue(defaultFont);
        this.fontWeightComboBox.setValue(defaultFontWeight);
        this.fontSizeComboBox.setValue(defaultFontSize);
        this.colorPicker.setValue(defaultColor);
    }

    @Override
    public void setStyles(TextGlyph textGlyph) {
        System.out.println("setting styles");
        this.fontComboBox.setValue(textGlyph.getFont().getName());
        this.fontWeightComboBox.setValue(fontWeightToString(textGlyph.getFontWeight()));
        this.fontSizeComboBox.setValue(textGlyph.getFontSize());
        this.colorPicker.setValue(textGlyph.getFontColor());
    }

    public String fontWeightToString(FontWeight fontWeight) {
        switch (fontWeight) {
            case BLACK:
                return "Black";
            case EXTRA_BOLD:
                return "Extra Bold";
            case BOLD:
                return "Bold";
            case SEMI_BOLD:
                return "Semi Bold";
            case MEDIUM:
                return "Medium";
            case NORMAL:
                return "Regular";
            case LIGHT:
                return "Light";
            case EXTRA_LIGHT:
                return "Extra Light";
            case THIN:
                return "Thin";
            default:
                return "Regular";
        }
    }
}
