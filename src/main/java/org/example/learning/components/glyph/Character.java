package org.example.learning.components.glyph;

import org.example.learning.components.WindowBox;

public class Character implements Glyph {
    private char c;

    public char getChar() {
        return c;
    }

    public void setChar(char c) {
        this.c = c;
    }

    @Override
    public void Draw(WindowBox windowPane) {
        windowPane.drawChar(c);
    }

    @Override
    public void Bounds(Rect rect) {

    }

    @Override
    public boolean Intersects(Point point) {
        return false;
    }

    @Override
    public void Insert(Glyph glyph, int index) {

    }
}
