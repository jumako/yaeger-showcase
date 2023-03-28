package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Sluipschutter extends Tegenstander {

    public static int grootte = 35;
    public static int snelheid = 3;
    public static int score = 5;
    public int levens = 200;
    public static int schade = 100;

    public Sluipschutter(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
        super("entities/sluipschutter.png", initialLocation, new Size(grootte, grootte), speler, scoreText);
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

