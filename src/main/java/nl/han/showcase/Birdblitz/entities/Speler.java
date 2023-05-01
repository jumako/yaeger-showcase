package nl.han.showcase.Birdblitz.entities;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.showcase.Birdblitz.KogelSpawner;
import nl.han.showcase.Birdblitz.entities.text.LevensText;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;
import nl.han.showcase.Birdblitz.scenes.Spelscherm;
import java.util.Set;

public class Speler extends DynamicSpriteEntity implements KeyListener,SceneBorderTouchingWatcher, Collided, UpdateExposer {

	private final LevensText levensText;
	private static int levens = 150;
	private final ScoreText scoreText;
	private int score = 0;
	private final KogelSpawner kogelSpawner;
	private Spelscherm spelscherm;
	private int upgrade = 0;
	private static int playerkills;


	public Speler(Coordinate2D locatie, LevensText levensText, ScoreText scoreText, KogelSpawner kogelSpawner, Spelscherm spelscherm, int upgrade, int playerkills) {
		super("entities/player.png", locatie, new Size(100, 100), 1, 1);
		this.levensText = levensText;
		levensText.setLevensText(levens);
		this.scoreText = scoreText;
		scoreText.setScoreText(getScore());
		this.kogelSpawner = kogelSpawner;
		this.setSpelscherm(spelscherm);
		this.upgrade = upgrade;
		this.playerkills = playerkills;
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if (collidingObject instanceof Tegenstander) {
			Tegenstander tegenstander = (Tegenstander) collidingObject;
			levens -= tegenstander.getSchade();
			System.out.println(tegenstander.getSchade());
			levensText.setLevensText(levens);
			this.setScore(this.getScore() + tegenstander.getScore());
			scoreText.setScoreText(this.getScore());
			tegenstander.remove();
			playerkills++;
		}
	}

	void setScore(int i) {
	}


	@Override
	public void notifyBoundaryTouching(SceneBorder border) {
		setSpeed(0);

		switch (border) {
			case LEFT:
				setAnchorLocationX(1);
				break;
			case RIGHT:
				setAnchorLocationX(getSceneWidth() - getWidth() - 1);
			default:
				break;
		}
	}


	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		int vogelSnelheid = Upgrades.UpgradeSnelheid(0);
		if (pressedKeys.contains(KeyCode.LEFT)) {
			setMotion(vogelSnelheid, 270d);
		} else if (pressedKeys.contains(KeyCode.RIGHT)) {
			setMotion(vogelSnelheid, 90d);
		}

		spatieIngedrukt(pressedKeys);
	}

	public void spatieIngedrukt(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.SPACE)) {
			kogelSpawner.resume();
		} else {
			kogelSpawner.pause();
		}
	}

	public Coordinate2D getSpelerLocatie() {
		Coordinate2D spelerLocatie;

		spelerLocatie = this.getLocationInScene();

		return spelerLocatie;
	}

	@Override
	public void explicitUpdate(final long timestamp) {
		kogelSpawner.setLocatie(getLocationInScene());
	}

	public int getScore() {
		return score;
	}


	public void setSpelscherm(Spelscherm spelscherm) {
		this.spelscherm = spelscherm;

	}


}
