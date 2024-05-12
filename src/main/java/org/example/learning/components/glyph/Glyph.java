package org.example.learning.components.glyph;

import org.example.learning.components.WindowBox;

public interface Glyph {
    public void Draw(WindowBox windowPane);

    public void Bounds(Rect rect);

    public boolean Intersects(Point point);

    public void Insert(Glyph glyph, int index);

}
