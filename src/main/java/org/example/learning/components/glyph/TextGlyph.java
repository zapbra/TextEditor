package org.example.learning.components.glyph;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class TextGlyph extends HBox {
    private Text text;
    private double fontSize = 12;
    private Font font = Font.getDefault();
    private Color fontColor = Color.BLACK;
    private FontWeight fontWeight;

    public TextGlyph(String textValue) {
        this.text = new Text(textValue);
        this.getChildren().add(text);
    }

    public void setText(String textValue) {
        this.text.setText(textValue);
    }

    public Text getText() {
        return text;
    }

    public String getTextValue() {
        return text.getText();
    }


    public void addBorder(String borderColor) {
        this.setStyle("-fx-border-color: " + borderColor + "; -fx-border-width: 1px");
    }

    public void removeBorder() {
        this.setStyle("-fx-border-color: none; -fx-border-width: 0;");
    }

    public void setFont(Font font) {
        this.font = font;
        this.text.setFont(font);
    }

    public Font getFont() {
        return font;
    }

    public void setFontSize(double fontSize) {
        this.fontSize = fontSize;
    }

    public double getFontSize() {
        return fontSize;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setFontWeight(FontWeight fontWeight) {
        this.fontWeight = fontWeight;
    }

    public FontWeight getFontWeight() {
        return fontWeight;
    }

}
