package frontend.ui.figures;

import backend.model.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.function.Predicate;

public abstract class DrawableFigure<F extends Figure> {

    private final F figure;

    private boolean selected = false;
    private static final Color SELECTED_COLOR = Color.RED;
    private static final Color LINE_COLOR = Color.BLACK;

    private Color figureColor;

    public DrawableFigure(F figure, Color figureColor) {
        this.figure = figure;
        this.figureColor = figureColor;
    }

    public F getFigure() {
        return figure;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void changeColor(Color color) {
         this.figureColor = color;
    }

    public void handleSelection(GraphicsContext gc) {
        // Handle figure selection
        gc.setFill(figureColor);
        gc.setStroke(selected ? SELECTED_COLOR : LINE_COLOR);
        //gc.setFill(figureColorMap.get(figure));
    }

    public abstract void draw(GraphicsContext gc);
}
