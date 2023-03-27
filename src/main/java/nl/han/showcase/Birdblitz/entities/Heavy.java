package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;


public class Heavy extends Tegenstander{
	
	public static int grootte = 50;
	public static int snelheid = 1;
	public int levens = 400;
	public static int score = 50;
	public static int schade = 100;
	

	public Heavy(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
		super("entities/Vulture.png", initialLocation, new Size(grootte,grootte), speler, scoreText);
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
		setMotion(snelheid,360);
	}
	
	public void setLevens() {
		
	}
	
	public int getLevens() {
		return this.levens;
	}

}
