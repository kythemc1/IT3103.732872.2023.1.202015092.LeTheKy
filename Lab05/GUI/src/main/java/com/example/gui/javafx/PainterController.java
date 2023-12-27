package com.example.gui.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup Tools;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        RadioButton curBtn = (RadioButton) Tools.getSelectedToggle();
        Circle newCircle;
        if(curBtn.getText().equals("Pen")) {
            newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        } else {
            newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
        }
        drawingAreaPane.getChildren().add(newCircle);
    }
}