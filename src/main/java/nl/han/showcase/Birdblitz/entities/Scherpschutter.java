package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.Random;

public abstract class Scherpschutter extends Tegenstander implements TimerContainer  {

    public static int grootte = 40;
    public static int snelheid = 1;
    public int levens = 200;
    public static int score = 50;
    public static int schade = 100;
    private Timer schietTimer;

    public Scherpschutter(Coordinate2D initialLocation, Speler speler, ScoreText scoreText) {
        super("entities/sluipschutter.png", initialLocation, new Size(grootte,grootte), speler, scoreText);
        schietTimer = new Timer(() -> schietKogel(), 2000);
        addTimer(schietTimer);
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

    public void Beweeg() {
        setMotion(snelheid, 360);
    }

    private void schietKogel() {
        Random random = new Random();
        double angle = random.nextDouble() * 180 + 90;
        Kogel kogel = new Kogel(new Coordinate2D(getAnchorLocation().getX(), getAnchorLocation().getY() + getHeight()), angle, 5, Scherpschutter.schade, Scherpschutter.class);
        getScene().addEntity(kogel);
    }

    public void setLevens() {

    }

    public int getLevens() {
        return this.levens;
    }

}