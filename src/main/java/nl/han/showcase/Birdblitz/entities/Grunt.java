package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

public class Grunt extends Tegenstander{
	
	public static int grootte = 50;
	public static int snelheid = 1;
	public int levens = 1;
	public static int score = 10;
	public static int schade = 1;
	

	public Grunt(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
		
		super("sprites/grunt.png", initialLocation, new Size(grootte,grootte), speler, scoreText);
		
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
	public void Beweeg() {
		// TODO Auto-generated method stub
		setMotion(snelheid,300);
	}




}
