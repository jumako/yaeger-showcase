package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Kogel extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider, Collided{

	public Kogel(Coordinate2D initialLocation) {
		super("sprites/kogel.png", initialLocation);
		// TODO Auto-generated constructor stub
		
		setMotion(10, 180);
	}

	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		remove();
	}
	
	
	@Override
	public void onCollision(Collider collidingObject) {
		remove();
	}
}
