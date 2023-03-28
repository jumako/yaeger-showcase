package nl.han.showcase.Birdblitz.scenes;
;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.showcase.Birdblitz.KogelSpawner;
import nl.han.showcase.Birdblitz.entities.*;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.ArrayList;
import java.util.Random;

public class Level {
    private int levelNumber;
    private int maxEnemies;
    public static int aantaltegenstanders;

    public Level(int levelNumber, int maxEnemies) {
        this.levelNumber = levelNumber;
        this.maxEnemies = maxEnemies;
    }

    public static ArrayList<Tegenstander> createEnemies(int aantalGrunt, int aantalHeavy, int aantalScherpschutter, int aantalSpeedy, int width, int height, Speler speler, ScoreText scoreText) {
        ArrayList<Tegenstander> tegenstanders = new ArrayList<>(); // Create new ArrayList

        Random r = new Random();
        int n = r.nextInt(4) + 1;

        if (n == 1 && aantalGrunt > 0) {
            tegenstanders.add(new Grunt(new Coordinate2D(width / 4, height / 12), speler, scoreText));
            aantalGrunt--;
        }

        if (n == 2 && aantalSpeedy > 0) {
            tegenstanders.add(new Speedy(new Coordinate2D(width / 4, height / 12), speler, scoreText));
            aantalSpeedy--;
        }
        if (n == 3 && aantalHeavy > 0) {
            tegenstanders.add(new Grunt(new Coordinate2D(width / 4, height / 12), speler, scoreText));
            aantalHeavy--;
        }
        if (n == 4 && aantalScherpschutter > 0) {
            tegenstanders.add(new Grunt(new Coordinate2D(width / 4, height / 12), speler, scoreText));
            aantalScherpschutter--;
        }
        int aantaltegenstanders = aantalGrunt + aantalHeavy + aantalScherpschutter + aantalSpeedy;
        if (aantaltegenstanders == 0) {
            Tegenstander boss = new Boss(new Coordinate2D(width, height / 12), speler, scoreText);
            tegenstanders.add(boss);
        }
        return tegenstanders; // Return the new ArrayList
    }

}