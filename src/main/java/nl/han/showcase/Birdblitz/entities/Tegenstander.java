package nl.han.showcase.Birdblitz.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.input.KeyCode;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.Set;

public abstract class Tegenstander extends DynamicSpriteEntity implements Collided, Collider, SceneBorderCrossingWatcher, UpdateExposer {

    protected Speler speler;
    protected ScoreText scoreText;

    public int score;

    public int levens;

    protected Tegenstander(String resource, Coordinate2D initialLocation, Size grootte, Speler speler, ScoreText scoreText) {
        super(resource, initialLocation, grootte);
        this.speler = speler;
        this.scoreText = scoreText;
    }

    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case TOP:
                break;
            case BOTTOM:
                setAnchorLocationY(-10);
                break;
            case LEFT:
                setAnchorLocationX(getSceneWidth() - 60);
                break;
            case RIGHT:
                setAnchorLocationX(0);
                break;
        }
    }

    protected static void ontvangSchade(int schade) {
    }


    public void explicitUpdate(final long timestamp) {
        beweeg();
    }

    public abstract void beweeg();

    {

    }

    public abstract void onPressedKeysChange(Set<KeyCode> pressedKeys);

    public abstract void geluid();

    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Kogel) {
            geluid();
            levens -= Kogel.schade;
            if (levens <= 0) {
                remove();
                Speler.Kill();
                speler.setScore(this.getScore() + getScore());
                scoreText.setScoreText(this.getScore());
            }
        }
    }

    public abstract int getSchade();

    public abstract int getScore();

}
