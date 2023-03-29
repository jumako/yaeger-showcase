package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.input.KeyCode;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.Set;


public class Grunt extends Tegenstander{
	
	public static int grootte = 70;
	public static int snelheid = 5;
	public int levens = 100;
	public static int score = 10;
	public static int schade = 50;
	

	public Grunt(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
		
		super("entities/grunt.png", initialLocation, new Size(grootte,grootte), speler, scoreText);
		
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Kogel) {
			levens = levens - 100;
			if (levens < 0) {
				remove();
				speler.setScore(speler.getScore() + score);
				scoreText.setScoreText(speler.getScore());
			}
		}
	}

	@Override
	public void Beweeg() {
		// TODO Auto-generated method stub
		setMotion(snelheid,360);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {

	}


}
