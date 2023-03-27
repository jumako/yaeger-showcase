package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

public abstract class Tegenstander extends DynamicSpriteEntity implements Collided,Collider, SceneBorderCrossingWatcher, UpdateExposer{

	protected Speler speler;
	protected ScoreText scoreText;

	public int score;

	protected Tegenstander(String resource, Coordinate2D initialLocation, Size grootte, Speler speler, ScoreText scoreText) {
		super(resource, initialLocation,grootte);
		this.speler = speler;
		this.scoreText = scoreText;
	}

	public void notifyBoundaryCrossing(SceneBorder border) {
		switch(border) {
			case TOP:
				break;
			case BOTTOM:
				setAnchorLocationY(-10);
				break;
			case LEFT:
				setAnchorLocationX(getSceneWidth()-60);
				//Pak grootte van de tegenstander en doe dat min sceneWidth
				break;
			case RIGHT:
				setAnchorLocationX(0);
				break;
		}
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Kogel) {
			ontvangSchade(Scherpschutter.schade);
			if (levens <= 0) {
				remove();
				speler.setScore(speler.getScore() + score);
				scoreText.setScoreText(speler.getScore());
				speler.checkAantalTegenstanders();
			}
		}
	}

	protected static void ontvangSchade(int schade) {
	}

	public void explicitUpdate(final long timestamp) {
		Beweeg();
	}

	public abstract void Beweeg();{

	}
}
