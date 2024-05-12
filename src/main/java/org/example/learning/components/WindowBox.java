package org.example.learning.components;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 * This is the main class which the user types into to draw on the screen
 */
public class WindowBox {
    /**
     * Width of the editor Pane
     */
    public static final int WIDTH = 600;
    /**
     * Current text row
     */
    private int currentRowIndex = 0;
    /**
     * Current text which the user is typing into
     */
    Text currentText = new Text("");
    /**
     * Text objects to be drawn on the screen
     */
    private ArrayList<TextFlow> textRows = new ArrayList<>();
    /**
     * Holds all the text elements
     */
    Pane pane;
    /**
     * Blinking cursor
     */
    LineCursor lineCursor;
    /**
     * Users current y Position on the screen
     */
    double yPos = 0;

    public WindowBox() {
        // initialize pane & set styling
        pane = new Pane();
        pane.setMinSize(600, 600);
        pane.getStyleClass().add("border-outline");

        textRows.add(new TextFlow(currentText));
        drawTextFlow(textRows.get(currentRowIndex));
        // add event handlers for when the user types to draw on the screen
        initializeFocusHandler();
        // draw the cursor
        initializeCursor();


    }

    public WindowBox(ArrayList<TextFlow> textRows) {
        super();
        this.textRows = textRows;
    }

    /**
     * Runs on initialization to start listening to keypress events
     * when the pane is clicked.
     */
    public void initializeFocusHandler() {
        /**
         * Adds focus to the Pane so it can listen to key events
         */
        pane.setOnMouseClicked(event -> {
            pane.requestFocus();
        });

        pane.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            // special character clicked. Ex. ctrl, tab, backspace
            if (event.getText().isEmpty()) {
                // enter key clicked
            } else if (event.getCode().equals(KeyCode.ENTER)) {
                startNewLine();
                // tab key clicked
            } else if (event.getCode().equals(KeyCode.TAB)) {
                currentText.setText(currentText.getText() + '\t');
                // alphanumerical character clicked. Update text and cursor position
            } else {
                currentText.setText(currentText.getText() + event.getText());
                Text text = new Text(event.getText());
                lineCursor.updatePosition(currentText.getLayoutX() + currentText.getLayoutBounds().getWidth() + text.getLayoutBounds().getWidth(), textRows.get(currentRowIndex).getLayoutY(), currentText.getLayoutBounds().getHeight());
            }
        });
    }

    // add TextFlow to the screen
    public void drawTextFlow(TextFlow textFlow) {
        pane.getChildren().add(textFlow);
    }

    // Starts a new line below the current one when the enter key is clicked.
    public void startNewLine() {
        currentRowIndex++;
        updateYPos();
        currentText = new Text("");
        if (textRows.size() <= currentRowIndex) {
            TextFlow newTextFlow = new TextFlow();
            newTextFlow.getChildren().add(currentText);
            newTextFlow.setLayoutY(yPos);
            textRows.add(newTextFlow);
            drawTextFlow(textRows.get(currentRowIndex));
        }
        lineCursor.updatePosition(0, yPos, currentText.getLayoutBounds().getHeight());
    }

    // update users Y position
    public void updateYPos() {
        yPos += currentText.getLayoutBounds().getHeight();
    }


    public Pane getPane() {
        return pane;
    }

    // start the cursor animation and add to the pane
    public void initializeCursor() {
        lineCursor = new LineCursor(0, 0, 10);
        lineCursor.setStroke(Color.BLACK);
        lineCursor.startTransition();
        pane.getChildren().add(lineCursor);
    }


}
