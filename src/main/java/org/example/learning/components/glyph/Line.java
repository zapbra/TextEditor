package org.example.learning.components.glyph;

import javafx.scene.text.TextFlow;

public class Line extends ListNode implements Element {
    private final TextFlow textFlow;

    public Line(TextGlyph textGlyph) {
        this.textFlow = new TextFlow(textGlyph);
    }

    public Line(TextFlow textFlow) {
        this.textFlow = textFlow;
    }

    public TextFlow getTextFlow() {
        return textFlow;
    }

    public void addBorder(String borderColor) {
        textFlow.setStyle("-fx-border-color: " + borderColor + "; -fx-border-width: 1px");
    }

    public void removeBorder() {
        textFlow.setStyle("-fx-border-color: none; -fx-border-width: 0;");
    }

}
