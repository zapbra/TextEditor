package org.example.learning.components.glyph;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class TextGlyph extends HBox {
    Text text;

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
}
