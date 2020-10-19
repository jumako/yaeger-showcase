package nl.han.showcase.scenes.shapeofyou.entities;

import com.github.hanyaeger.api.engine.UpdateExposer;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.shape.circle.DynamicCircleEntity;
import javafx.scene.paint.Color;
import nl.han.showcase.YaegerShowCase;

/**
 * A rather straightforward {@link DynamicCircleEntity} that implements the {@link UpdateExposer}
 * interface. In contrary to using a {@link com.github.hanyaeger.api.engine.Timer}, the {@link UpdateExposer}
 * interfaces exposes an {@link UpdateExposer#explicitUpdate(long)} method, that will be called on every
 * Game World Update.
 * <p>
 * In this case we use the {@link UpdateExposer#explicitUpdate(long)} to change the {@code radius} of the
 * {@link com.github.hanyaeger.api.engine.entities.entity.shape.circle.CircleEntity}.
 */
public class UpdatingCircle extends DynamicCircleEntity implements UpdateExposer {

    private static final double MIN_RADIUS = 1;
    private static final double MAX_RADIUS = 40;
    private static final double RADIUS_INCREMENT = 0.5;
    private static boolean INCREMENT = true;

    public UpdatingCircle(final Coordinate2D initialLocation) {
        super(initialLocation);

        setRadius(MIN_RADIUS);
        setFill(YaegerShowCase.HAN_RED);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(1);
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        if (INCREMENT) {
            if (getRadius() < MAX_RADIUS) {
                setRadius(getRadius() + RADIUS_INCREMENT);
            } else {
                INCREMENT = false;
            }
        }
        if (!INCREMENT) {
            if (getRadius() > MIN_RADIUS) {
                setRadius(getRadius() - RADIUS_INCREMENT);
            } else {
                INCREMENT = true;
            }
        }
    }
}