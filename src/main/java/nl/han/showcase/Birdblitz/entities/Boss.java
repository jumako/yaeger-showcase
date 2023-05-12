package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.input.KeyCode;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;
;import java.util.Set;

public class Boss extends Tegenstander{
	
	public static int grootte = 300;
	public int levens = 5000;
	public static int snelheid = 3;

	public static int schade = 500;

	public Boss(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
		super("entities/boss.png",initialLocation ,new Size(grootte,grootte),speler,scoreText);
	}

	@Override
	public int getSchade() {
		return schade;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void beweeg() {
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

	@Override
	public void geluid() {

	}


}

