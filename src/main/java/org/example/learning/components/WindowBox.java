package org.example.learning.components;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the main class which the user types into to draw on the screen
 */
public class WindowBox {
    /**
     * Width of the editor Pane
     */
    public static final int WIDTH = 600;

    /**
     * Padding for the text area (pane)
     */
    public static final int PADDING = 8;
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
            System.out.println("key clicked");
            System.out.println("text: " + event.getText());
            System.out.println("code: " + event.getCode());
            // special character clicked. Ex. ctrl, tab, backspace
            if (event.getText().isEmpty()) {
                // delete key clicked
                if (event.getCode().equals(KeyCode.BACK_SPACE)) {
                    deleteLetter();
                }
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

    public void deleteLetter() {
        String currentTextContent = currentText.getText();
        ObservableList<Node> textRowChildren = textRows.get(currentRowIndex).getChildren();
        // delete character if there is character to delete
        if (!currentTextContent.isEmpty()) {
            String charToRemove = String.valueOf(currentTextContent.charAt(currentTextContent.length() - 1));
            currentText.setText(currentTextContent.substring(0, currentTextContent.length() - 1));
            lineCursor.updatePosition(currentText.getLayoutX() + currentText.getLayoutBounds().getWidth() - new Text(charToRemove).getLayoutBounds().getWidth(), textRows.get(currentRowIndex).getLayoutY(), currentText.getLayoutBounds().getHeight());
            // delete line and move cursor position up a line if no characters left in line
        } else if (!textRowChildren.isEmpty()) {
            if (textRowChildren.size() > 1) {
                textRowChildren.remove(textRowChildren.size() - 1);
                currentText = (Text) textRowChildren.get(textRowChildren.size() - 1);
            } else {
                deleteLine();
            }
        } else {
            //deleteLine();
        }


    }

    //

    /**
     * Starts a new line below the current one when the enter key is clicked.
     */
    public void startNewLine() {
        currentRowIndex++;
        increaseYPos();
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

    /**
     * Deletes the current text line
     */
    public void deleteLine() {
        // delete line if not on first line (might need to be changed)
        if (currentRowIndex > 0) {
            // removes the TextFlow line
            textRows.remove(currentRowIndex);
            shiftLinesUp(currentRowIndex);
            // moves the cursor one line up
            currentRowIndex--;
            decreaseYPos();
            TextFlow currentTextFlow = textRows.get(currentRowIndex);
            currentText = new Text("");
            currentTextFlow.getChildren().add(currentText);
            lineCursor.updatePosition(currentTextFlow.getLayoutBounds().getWidth(), yPos, currentText.getLayoutBounds().getHeight());
        }
    }

    // update users Y position
    public void increaseYPos() {
        System.out.println("y pos b4 inc");
        System.out.println(yPos);
        yPos += currentText.getLayoutBounds().getHeight();
        System.out.println("y pos after");
        System.out.println(yPos);
    }

    public void decreaseYPos() {
        System.out.println("y pos b4 dec");
        System.out.println(yPos);
        yPos -= currentText.getLayoutBounds().getHeight();
        System.out.println("y pos after");
        System.out.println(yPos);
    }

    public void shiftLinesUp(int rowIndex) {
        for (int i = rowIndex; i < textRows.size(); i++) {
            TextFlow currentRow = textRows.get(i);
            currentRow.setLayoutY(currentRow.getLayoutY() - currentText.getLayoutBounds().getHeight());
        }
    }


    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    // start the cursor animation and add to the pane
    public void initializeCursor() {
        lineCursor = new LineCursor(PADDING, PADDING, 10);
        lineCursor.setStroke(Color.BLACK);
        lineCursor.startTransition();
        pane.getChildren().add(lineCursor);
    }


}
