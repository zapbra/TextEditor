package org.example.learning.components;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class LineCursor extends Line {
    public static int DURATION = 1000;

    public LineCursor(double startX, double startY, double height) {

        super(startX, startY, startX, startY + height);
    }

    public void startTransition() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), e -> this.setVisible(false)),
                new KeyFrame(Duration.seconds(1), e -> this.setVisible(true))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void updatePosition(double x, double y, double height) {
        setStartX(x);
        setEndX(x);
        setStartY(y);
        setEndY(y + height);
    }
}
