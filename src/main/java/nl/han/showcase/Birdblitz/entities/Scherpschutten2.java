package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import javafx.scene.input.KeyCode;
import nl.han.showcase.Birdblitz.KogelSpawner;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;
import

import java.util.Set;

public class Scherpschutten2 extends Tegenstander {
    public static int grootte = 40;
    public static int snelheid = 1;
    public static int levens = 200;
    public static int score = 50;
    public static int schade = 100;
    private final KogelSpawner kogelSpawner;
    public Scherpschutten2(Coordinate2D initialLocation, Speler speler, ScoreText scoreText,KogelSpawner kogelSpawner) {
        super("entities/Speedy.png", initialLocation, new Size(grootte,grootte), speler, scoreText);
        this.kogelSpawner = kogelSpawner;
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
    @Override
    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.SPACE)) {
            // Spawn a bullet at the current location of the Scherpschutten2 entity
            Coordinate2D bulletLocation = getLocation();
            Kogel kogel = new Kogel(bulletLocation, speler);
            getSceneManager().addEntity(kogel);
        }
    }


}

