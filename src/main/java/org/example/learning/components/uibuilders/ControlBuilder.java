package org.example.learning.components.uibuilders;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.material2.Material2AL;
import org.kordamp.ikonli.material2.Material2MZ;

import java.util.Arrays;
import java.util.List;

public class ControlBuilder {
    private final List<String> fontList = Font.getFamilies();
    private final String defaultFont = Font.getDefault().getName();
    private final String[] fontWeightArray = new String[]{"Thin", "Extra Light", "Light", "Regular", "Medium", "Semi Bold",
            "Bold", "Extra Bold", "Black"};
    private final String defaultFontWeight = "Regular";
    private final Double[] fontSizes = new Double[]{10.0, 11.0, 12.0, 13.0, 14.0, 15.0,
            16.0, 20.0, 24.0, 32.0, 36.0, 40.0, 48.0, 64.0, 96.0, 128.0};
    private final double defaultFontSize = 12;
    private final Color defaultColor = Color.BLACK;

    private VBox sidebarVBox;

    public ControlBuilder(VBox sidebarVBox) {
        this.sidebarVBox = sidebarVBox;
    }


    public void buildAlignmentCommands() {


        // build the horizontal line alignment buttons
        // left alignment button
        FontIcon leftAlignmentIcon = new FontIcon(Material2AL.ALIGN_HORIZONTAL_LEFT);
        Button leftAlignmentButton = new Button();
        leftAlignmentButton.setGraphic(leftAlignmentIcon);

        // center alignment button
        FontIcon centerAlignmentIcon = new FontIcon(Material2AL.ALIGN_HORIZONTAL_CENTER);
        Button centerAlignmentButton = new Button();
        centerAlignmentButton.setGraphic(centerAlignmentIcon);

        // right alignment button
        FontIcon rightAlignmentIcon = new FontIcon(Material2AL.ALIGN_HORIZONTAL_RIGHT);
        Button rightAlignmentButton = new Button();
        rightAlignmentButton.setGraphic(rightAlignmentIcon);

        // create the horizontal alignment h box and populate it
        HBox horizontalAlignmentHBox = new HBox();
        HBox.setHgrow(horizontalAlignmentHBox, Priority.ALWAYS);
        horizontalAlignmentHBox.setSpacing(8);
        horizontalAlignmentHBox.getChildren().addAll(leftAlignmentButton, centerAlignmentButton, rightAlignmentButton);


        // build the vertical line alignment buttons
        // top alignment button
        FontIcon topAlignmentIcon = new FontIcon(Material2AL.ALIGN_VERTICAL_TOP);
        Button topAlignmentButton = new Button();
        topAlignmentButton.setGraphic(topAlignmentIcon);

        // center vertical alignment button
        FontIcon centerVerticalAlignmentIcon = new FontIcon(Material2AL.ALIGN_VERTICAL_CENTER);
        Button centerVerticalAlignmentButton = new Button();
        centerVerticalAlignmentButton.setGraphic(centerVerticalAlignmentIcon);

        // right alignment button
        FontIcon bottomAlignmentIcon = new FontIcon(Material2AL.ALIGN_VERTICAL_BOTTOM);
        Button bottomAlignmentButton = new Button();
        bottomAlignmentButton.setGraphic(bottomAlignmentIcon);

        // create the horizontal alignment h box and populate it
        HBox verticalAlignmentHBox = new HBox();
        HBox.setHgrow(verticalAlignmentHBox, Priority.ALWAYS);
        verticalAlignmentHBox.getChildren().addAll(topAlignmentButton, centerVerticalAlignmentButton, bottomAlignmentButton);
        verticalAlignmentHBox.setSpacing(8);

        sidebarVBox.getChildren().addAll(horizontalAlignmentHBox, verticalAlignmentHBox);

    }


    public void buildColorPicker() {


        Separator separator = new Separator();

        // create label
        Label colorLabel = new Label("Color");
        colorLabel.getStyleClass().add("bold");

        // create color picker
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(defaultColor);

        sidebarVBox.getChildren().addAll(separator, colorLabel, colorPicker);
    }

    public void buildStrokeSection() {
        Separator separator = new Separator();

        // create label
        Label strokeLabel = new Label("Stroke");
        strokeLabel.getStyleClass().add("bold");

        // create expand button
        FontIcon plusIcon = new FontIcon(Material2MZ.PLUS);
        Button expandButton = new Button();
        expandButton.setGraphic(plusIcon);
        expandButton.setLayoutX(140);

        // create title and button holder
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(strokeLabel, expandButton);


        sidebarVBox.getChildren().addAll(separator, anchorPane);
    }

    public void buildEffectsSection() {
        Separator separator = new Separator();

        // create label
        Label strokeLabel = new Label("Effects");
        strokeLabel.getStyleClass().add("bold");

        // create expand button
        FontIcon plusIcon = new FontIcon(Material2MZ.PLUS);
        Button expandButton = new Button();
        expandButton.setGraphic(plusIcon);
        expandButton.setLayoutX(140);

        // create title and button holder
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(strokeLabel, expandButton);


        sidebarVBox.getChildren().addAll(separator, anchorPane);
    }

    public void buildFontCommands() {
        // Font header label
        Label label = new Label("Font");
        label.getStyleClass().add("bold");
        label.getStyleClass().add("font-medium");

        // Font combo box
        ComboBox<String> fontComboBox = new ComboBox<>(FXCollections.observableArrayList(fontList));
        fontComboBox.setValue(defaultFont);
        fontComboBox.setMaxWidth(Double.MAX_VALUE);
        fontComboBox.setMaxWidth(160);
        // Grid selection
        GridPane gridPane = new GridPane();
        gridPane.setVgap(8);
        gridPane.setHgap(8);

        // Font weight combo box
        ComboBox<String> fontWeightComboBox = new ComboBox<>();
        fontWeightComboBox.setItems(FXCollections.observableArrayList(fontWeightArray));
        fontWeightComboBox.setValue(defaultFontWeight);

        // Font size combo box
        ComboBox<Double> fontSizeComboBox = new ComboBox<>();
        fontSizeComboBox.setItems(FXCollections.observableArrayList(fontSizes));
        fontSizeComboBox.setEditable(true);
        fontSizeComboBox.setValue(defaultFontSize);
        fontSizeComboBox.setMaxWidth(100);

        // Minus Button
        FontIcon minusIcon = new FontIcon(Material2MZ.MINUS);
        Button minusButton = new Button();
        minusButton.setGraphic(minusIcon);

        // Plus Button
        FontIcon plusIcon = new FontIcon(Material2MZ.PLUS);
        Button plusButton = new Button();
        plusButton.setGraphic(plusIcon);

        // Font size section
        HBox fontSizeHBox = new HBox();
        HBox.setHgrow(fontSizeHBox, Priority.ALWAYS);
        fontSizeHBox.setSpacing(8);
        fontSizeHBox.getChildren().addAll(fontSizeComboBox, minusButton, plusButton);


        sidebarVBox.getChildren().addAll(label, fontComboBox, fontWeightComboBox, fontSizeHBox);
    }

    public void buildFontCommandBar() {
        buildFontCommands();
        buildAlignmentCommands();
        buildColorPicker();
        buildStrokeSection();
        buildEffectsSection();
    }
}
