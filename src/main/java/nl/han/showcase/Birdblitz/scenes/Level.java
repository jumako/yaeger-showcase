package nl.han.showcase.Birdblitz.scenes;

;
import com.github.hanyaeger.api.Coordinate2D;
import nl.han.showcase.Birdblitz.entities.*;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.ArrayList;
import java.util.Random;

public class Level {
    private int levelNumber;
    private int maxEnemies;
    public static int aantaltegenstanders = 0;
    public static int verslagenTegenstanders;

    public Level(int levelNumber, int maxEnemies) {
        this.levelNumber = levelNumber;
        this.maxEnemies = maxEnemies;
    }

    public static ArrayList<Tegenstander> createEnemies(int aantalGrunt, int aantalHeavy, int aantalScherpschutter, int aantalSpeedy, double width, double height, Speler speler, ScoreText scoreText) {
        ArrayList<Tegenstander> tegenstanders = new ArrayList<>(); // Create new ArrayList
        int aantaltegenstanders = 10;
        int n = Random(4);
        for (int i = 0; i < aantaltegenstanders; i++) {
                if (n == 0 ) {
                    if (aantalGrunt > 0) {
                        tegenstanders.add(new Grunt(new Coordinate2D(width / 4, height / 12), speler, scoreText));
                        aantalGrunt--;
                    }

                } else if (n == 1 && aantalSpeedy > 0) {
                    tegenstanders.add(new Speedy(new Coordinate2D(width / 4, height / 12), speler, scoreText));
                    aantalSpeedy--;
                } else if (n == 2 && aantalHeavy > 0) {
                    tegenstanders.add(new Heavy(new Coordinate2D(width / 4, height / 12), speler, scoreText));
                    aantalHeavy--;
                } else if (n == 3 && aantalScherpschutter > 0) {
                    tegenstanders.add(new Sluipschutter(new Coordinate2D(width / 4, height / 12), speler, scoreText));
                    aantalScherpschutter--;
                }

            }




        return tegenstanders; // Return the new ArrayList
    }






    private static int Random ( int maxgetal){
            Random r = new Random();
            int n = r.nextInt(maxgetal) ;
            return n;
        }
    }