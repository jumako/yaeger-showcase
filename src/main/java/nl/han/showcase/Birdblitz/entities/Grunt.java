package nl.han.showcase.Birdblitz.entities;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.media.SoundClip;
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
	public void beweeg() {
		setMotion(snelheid,360);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {

	}

	@Override
	public void geluid() {
		new SoundClip("audio/GruntDeathSound.mp3");
	}

	public int getSchade() {
		return schade;
	}

	public int getScore() {
		return score;
	}
}
