package nl.han.showcase.scenes.distance;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.showcase.scenes.distance.entities.energyball.EnergyBall;

import java.util.Random;

/**
 * As its name suggests, the {@link RocketSpawner} is an {@link EntitySpawner}
 * that is responsible for spawning the rockets.
 */
public class RocketSpawner extends EntitySpawner {

    private final Coordinate2D location;
    private TheDistanceScene theDistanceScene;
    private double direction = Direction.UP.getValue();

    private double requestedHue = 0D;
    private double requestedSaturation = 0D;

    public RocketSpawner(Coordinate2D location, final TheDistanceScene theDistanceScene) {
        super(500);
        this.location = location;
        this.theDistanceScene = theDistanceScene;
    }

    @Override
    protected void spawnEntities() {
        // We use a rondom boolean value to decide if we spawn a new rocket.
        if (new Random().nextBoolean()) {
            var newBall = new EnergyBall(location, direction, theDistanceScene);
            newBall.setHue(requestedHue);
            newBall.setSaturation(requestedSaturation);
            // Set the viewOrder to a value higher that the default to ensure the rockets appear from behind
            // the rocket launcher.
            newBall.setViewOrder(42);
            spawn(newBall);
        }
    }

    /**
     * The direction is used to decide in which direction the newly Spawned Entity should travel.
     * By calling this setter, the new direction is set, which is then passed to the new {@link EnergyBall},
     * through its constructor.
     *
     * @param direction The direction in which the next {@link EnergyBall} should travel.
     */
    public void setDirection(final double direction) {
        this.direction = direction;
    }

    public void setHue(double definedHue) {
        this.requestedHue = definedHue;
    }

    public void setSaturation(double definedSaturation) {
        requestedSaturation = definedSaturation;
    }
}
