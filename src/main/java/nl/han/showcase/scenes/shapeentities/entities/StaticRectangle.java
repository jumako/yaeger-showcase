package nl.han.showcase.scenes.shapeentities.entities;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.shape.rectangle.RectangleEntity;
import javafx.scene.paint.Color;

public class StaticRectangle extends RectangleEntity {

    public StaticRectangle(Location initialPosition) {
        super(initialPosition);
        setWidth(40);
        setHeight(80);
        setFill(Color.DARKBLUE);
        setStrokeColor(Color.LIGHTCORAL);
        setStrokeWidth(6);
    }
}
