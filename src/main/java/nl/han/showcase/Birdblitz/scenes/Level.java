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

        if (aantaltegenstanders <=10) {
            int n = RandomVogel(4);
            aantaltegenstanders++;
                if (n == 1 && aantalGrunt > 0) {
                    tegenstanders.add(new Grunt(new Coordinate2D(width / 4, height / 12), speler, scoreText));
                    aantalGrunt--;
                } else if (n == 2 && aantalSpeedy > 0) {
                    tegenstanders.add(new Speedy(new Coordinate2D(width / 4, height / 12), speler, scoreText));
                    aantalSpeedy--;
                } else if (n == 3 && aantalHeavy > 0) {
                    tegenstanders.add(new Heavy(new Coordinate2D(width / 4, height / 12), speler, scoreText));
                    aantalHeavy--;
                } else if (n == 4 && aantalScherpschutter > 0) {
                    aantalScherpschutter--;
                }
            }


            return tegenstanders; // Return the new ArrayList
        }




        private static int RandomVogel ( int maxgetal){
            Random r = new Random();
            int n = r.nextInt(maxgetal) + 1;
            return n;
        }
    }