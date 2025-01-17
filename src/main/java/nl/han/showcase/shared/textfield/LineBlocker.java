package nl.han.showcase.shared.textfield;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class LineBlocker extends RectangleEntity {

    protected LineBlocker(final Coordinate2D initialPosition, final double width) {
        super(initialPosition);
        setFill(Color.BLACK);
        setWidth(width);
        setHeight(10);
    }
}
