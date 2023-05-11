
package nl.han.showcase.Birdblitz.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.showcase.Birdblitz.Birdblitz;
import nl.han.showcase.Birdblitz.KogelSpawner;
import nl.han.showcase.Birdblitz.entities.Boss;
import nl.han.showcase.Birdblitz.entities.Speler;
import nl.han.showcase.Birdblitz.entities.Tegenstander;
import nl.han.showcase.Birdblitz.entities.text.KillText;
import nl.han.showcase.Birdblitz.entities.text.LevensText;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.ArrayList;


public class Spelscherm extends DynamicScene implements EntitySpawnerContainer {

    private KogelSpawner kogelSpawner;
    private static Birdblitz birdblitz;
    private int level;

    public Spelscherm(Birdblitz birdblitz, int level) {
        this.birdblitz = birdblitz;
        this.level = level;
    }



    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/hanboven.png");
        kogelSpawner = new KogelSpawner(100);
        setLevel(level);
    }

    @Override
    public void setupEntities() {
        LevensText levensText = new LevensText(new Coordinate2D(50, 750));
        addEntity(levensText);
        levensText.setLevensText();

        ScoreText scoreText = new ScoreText(new Coordinate2D(650, 750));
        addEntity(scoreText);
        scoreText.setScoreText(0);

        KillText killText =  new KillText(new Coordinate2D(300,750));
        addEntity(killText);
        killText.setKillText(0);

        Speler speler = new Speler(new Coordinate2D(getWidth() / 2, getHeight() / 8 * 7), levensText, scoreText, kogelSpawner, this,killText);
        addEntity(speler);
        setupEnemies(speler, scoreText);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(kogelSpawner);
    }

    private void setLevel(int level) {
        if (level == 1) {
            new Level(4, 3, 1, 2);
            System.out.println(level);
        } else if (level == 2) {
            new Level(0, 6, 3, 5);
        } else if (level == 3) {
            new Level(0, 10, 5, 0);
        }
    }

    private void setupEnemies(Speler speler, ScoreText scoreText) {
        ArrayList<Tegenstander> enemies = Level.createEnemies(getWidth(), getHeight(), speler, scoreText);
       System.out.println(Tegenstander.aantalTegenstanders + "test");
        for (Tegenstander enemy : enemies) {
                // Speler.getPlayerKills();
                addEntity(enemy);
            }
    }

    public void spawnBoss(boolean boss, Speler speler, ScoreText scoreText) {
        if (boss) {
            Boss bossEntity = new Boss(new Coordinate2D(getWidth() / 2, getHeight() / 12), speler, scoreText);
            addEntity(bossEntity);
        }
    }
    public static void EndGame(){
           birdblitz.setActiveScene(2);
    }


}