package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.input.KeyCode;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.Set;


public class Speedy extends Tegenstander{
	
	public static int grootte = 70;
	public static int snelheid = 7;
	public static int score = 10;
	public int levens = 100;
	public static int schade = 50;

	public Speedy(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
		super("entities/Speedy.png", initialLocation, new Size(grootte,grootte), speler, scoreText);
	}


	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Kogel) {
			levens = levens - 100;
			if (levens < 0) {
				remove();
				speler.setScore(speler.getScore() + score);
				scoreText.setScoreText(speler.getScore());
				speler.checkAantalTegenstanders();
			}
		}
	}


	@Override
	public void Beweeg() {
		if(speler.getSpelerLocatie().getX() > this.getLocationInScene().getX()) {
			setMotion(snelheid,30);
		}
		else if(speler.getSpelerLocatie().getX() == this.getLocationInScene().getX()){
			setMotion(snelheid,360);
		}
		else {
			setMotion(snelheid, 330);
		}
		
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {

	}

}
