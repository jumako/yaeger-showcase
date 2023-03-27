package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

class enemyKogel extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider, Collided {
	private int schade;
	private Class schutterClass;

	public enemyKogel(Coordinate2D initialLocation, double angle, int snelheid, int schade, Class schutterClass) {
		super("entities/enemyprojectile.png", initialLocation);

		setMotion(snelheid, angle);
		this.schade = schade;
		this.schutterClass = schutterClass;
	}

	public enemyKogel(Coordinate2D initialLocation, Speler speler) {
		super("entities/enemyprojectile.png", initialLocation, new Size(40, 40));
		setMotion(10, 180);
	}
	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		remove();
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject.getClass() == schutterClass) {
			Tegenstander tegenstander = (Tegenstander) collidingObject;
			Tegenstander.ontvangSchade(schade);
		}
		remove();
	}

	public void setImage(String s) {
	}
}
public class Kogel extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider, Collided{


	private int schade;
	private Class schutterClass;

	public Kogel(Coordinate2D initialLocation, double angle, int snelheid, int schade, Class schutterClass) {
		super("sprites/kogel.png", initialLocation);

		setMotion(snelheid, angle);
		this.schade = schade;
		this.schutterClass = schutterClass;
	}
	public Kogel(Coordinate2D initialLocation) {
		super("entities/playerprojectile.png", initialLocation, new Size(40, 40));
		setMotion(10, 180);
	}


	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		remove();
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject.getClass() == schutterClass) {
			Tegenstander tegenstander = (Tegenstander) collidingObject;
			Tegenstander.ontvangSchade(schade);
		}
		remove();
	}
}