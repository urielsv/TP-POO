package frontend.ui.bars;

import backend.model.*;
import frontend.CanvasState;
import frontend.ui.buttons.ActionButton;
import frontend.ui.buttons.DeleteButton;
import frontend.ui.buttons.FigureButton;
import frontend.ui.buttons.SelectionButton;
import frontend.ui.figures.DrawableEllipse;
import frontend.ui.figures.DrawableRectangle;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javax.swing.*;

public class SideBar extends VBox {

    // Botones Barra Izquierda
    private final ToggleButton deleteButton = new ToggleButton("Borrar");
    private final CanvasState canvasState;

    private ToggleGroup tools = new ToggleGroup();

    public SideBar(CanvasState canvasState) {
            super(10);
            this.canvasState = canvasState;
            setPadding(new Insets(5));
            setStyle("-fx-background-color: #999;");
            setPrefWidth(100);



        //Figure Buttons
        FigureButton<Circle> circleButton = new FigureButton<>("Círculo", canvasState,
                (start, end) -> new DrawableEllipse<>(new Circle(start, end.getX() - start.getX())));

        FigureButton<Rectangle> rectangleButton = new FigureButton<>("Rectángulo", canvasState,
                (start, end) -> new DrawableRectangle<>(new Rectangle(start, end)));

        FigureButton<Ellipse> ellipseButton = new FigureButton<>("Elipse", canvasState,
                (start, end) -> new DrawableEllipse<>(new Ellipse(
                    new Point(Math.abs(end.getX() + start.getX()) / 2, (Math.abs((end.getY() + start.getY())) / 2)),
                    Math.abs(end.getX() - start.getX()),
                    Math.abs(end.getY() - start.getY()))));

        FigureButton<Square> squareButton = new FigureButton<>("Cuadrado", canvasState,
                (start, end) -> new DrawableRectangle<>(new Square(start, end.getX() - start.getX())));


        // Other buttons
        ColorPicker fillColorPicker = new ColorPicker(Color.YELLOW);
        SelectionButton selectionButton = new SelectionButton(canvasState);

        ToggleButton[] toolsArr = {selectionButton, circleButton, rectangleButton, ellipseButton, squareButton, deleteButton};

        for (ToggleButton tool : toolsArr) {
            tool.setMinWidth(90);
            tool.setToggleGroup(tools);
            tool.setCursor(Cursor.HAND);
        }

		getChildren().add(fillColorPicker);
        getChildren().addAll(toolsArr);
        setPadding(new Insets(5));
        setStyle("-fx-background-color: #282828");
        setPrefWidth(100);

    }

    public ToggleGroup getTools() {
        return tools;
    }

    public ToggleButton getDeleteButton() {
        return deleteButton;
    }

}
