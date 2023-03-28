package nl.han.showcase.Birdblitz.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.showcase.Birdblitz.Birdblitz;
import nl.han.showcase.Birdblitz.KogelSpawner;
import nl.han.showcase.Birdblitz.entities.Speler;
import nl.han.showcase.Birdblitz.entities.Tegenstander;
import nl.han.showcase.Birdblitz.entities.text.LevensText;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.ArrayList;


public class Spelscherm extends DynamicScene implements EntitySpawnerContainer{

    //private Speler speler;
    private KogelSpawner kogelSpawner;
    private Birdblitz birdblitz;
    public int huidigeTegenstanders;
    public int level = 1;

    public Spelscherm(Birdblitz birdblitz , int level) {
        this.birdblitz = birdblitz;
        this.level = level;
    }

    @Override
    public void setupScene() {
        // TODO Auto-generated method stub
        setBackgroundImage("backgrounds/hanboven.png");
        kogelSpawner = new KogelSpawner(100);
    }

    @Override
    public void setupEntities() {
        var levensText = new LevensText(new Coordinate2D(50,950));
        addEntity(levensText);
        levensText.setLevensText();

        var scoreText = new ScoreText(new Coordinate2D(650,950));
        addEntity(scoreText);
        scoreText.setScoreText(0);

        var speler = new Speler(new Coordinate2D(getWidth()/2, getHeight() / 8 * 7), levensText,scoreText,kogelSpawner,this);
        addEntity(speler);

        setupTegenstanders(speler,scoreText);
    }

    @Override
    public void setupEntitySpawners() {

        addEntitySpawner(kogelSpawner);
    }

    public void setupTegenstanders(Speler speler, ScoreText scoreText) {
        if (level == 1) {
            ArrayList<Tegenstander> tegenstanders = Level.createEnemies(1, 1, 1, 1, (int) getWidth(), (int) getHeight(), speler, scoreText); // Assign the returned ArrayList
            for (Tegenstander t : tegenstanders) {
            }
        }
    }



    public void setHuidigeTegenstanders(int huidig) {
        huidigeTegenstanders = huidig;
    }

    public int getHuidigeTegenstanders() {
        return huidigeTegenstanders;
    }



}