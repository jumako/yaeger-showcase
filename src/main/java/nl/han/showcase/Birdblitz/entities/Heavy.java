package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.input.KeyCode;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.Set;


public class Heavy extends Tegenstander {

	public static int grootte = 100;
	public static int snelheid = 1;
	public int levens = 400;
	public static int score = 50;
	public static int schade = 100;


	public Heavy(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
		super("entities/Vulture.png", initialLocation, new Size(grootte, grootte), speler, scoreText);
	}
	@Override
	public void beweeg() {
		setMotion(snelheid, 360);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {

	}

	@Override
	public void geluid() {

	}
}