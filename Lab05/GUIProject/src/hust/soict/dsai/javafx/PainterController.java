package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML 
    private TitledPane Tools;
    @FXML 
    private ToggleGroup toggle;
    @FXML 
    private Pane drawingAreaPane;
    @FXML 
    private RadioButton penRadioButton;
    @FXML 
    private RadioButton eraserRadioButton;
    @FXML 
    private Paint color = Color.BLACK;

    @FXML
    public void intitialize() {
        penRadioButton.setToggleGroup(toggle);
        eraserRadioButton.setToggleGroup(toggle);;
    }
    
    @FXML
    void chooseToolPressed(ActionEvent e) {
        if (penRadioButton.isSelected()) {
            this.color = Color.BLACK;
        } else if (eraserRadioButton.isSelected()) {
            this.color = Color.WHITE;
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

}