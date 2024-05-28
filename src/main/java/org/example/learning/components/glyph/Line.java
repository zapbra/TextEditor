package org.example.learning.components.glyph;

import javafx.scene.text.TextFlow;

public class Line extends ListNode {
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

}
