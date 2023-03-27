package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;


public class Scherpschutter extends Tegenstander{

    public static int grootte = 40;
    public static int snelheid = 1;
    public int  levens = 200;
    public static int score = 50;
    public static int schade = 100;


    public Scherpschutter(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
        super("entities/sluipschutter.png", initialLocation, new Size(grootte,grootte), speler, scoreText);
    }

    protected Scherpschutter(String resource, Coordinate2D initialLocation, Size grootte, Speler speler, ScoreText scoreText) {
        super(resource, initialLocation, grootte, speler, scoreText);
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