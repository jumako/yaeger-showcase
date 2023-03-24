package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.birdblitz.entities.text.ScoreText;

public class Boss extends Tegenstander{
	
	public static int grootte = 100;
	public int levens = 10;
	public static int snelheid = 1;
	
	public Boss(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
		super("sprites/boss.png",initialLocation ,new Size(grootte,grootte),speler,scoreText);
	}
	
	@Override
	public void onCollision(Collider collidingObject) {
		if(collidingObject instanceof Kogel) {
			levens--;
			if(levens<0) {
				remove();
				speler.setScore(speler.getScore() + score);
				scoreText.setScoreText(speler.getScore());
				speler.checkAantalTegenstanders();
			}
		}
		}
	
	@Override
	public void notifyBoundaryCrossing(SceneBorder border) {
		switch(border) {
		case LEFT:
			setMotion(snelheid,90);
			break;
		case RIGHT:
			setMotion(snelheid,270);
			break;
		default:
			break;
		}
	}

	@Override
	public void Beweeg() {
		setMotion(snelheid,90);
	}




}

