package org.example.learning.components.glyph;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class TextGlyph extends HBox {
    Text text;
    double fontSize = 12;
    Font font = Font.getDefault();
    Color fontColor = Color.BLACK;

    public TextGlyph(String textValue) {
        this.text = new Text(textValue);
        this.getChildren().add(text);
    }

    public void setText(String textValue) {
        this.text.setText(textValue);
    }

    public String getText() {
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
    }

    public void setFontSize(double fontSize) {
        this.fontSize = fontSize;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }
}
