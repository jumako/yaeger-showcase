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
    public static int verslagenTegenstanders;
    public static int huidigeTegenstanders;

    private static int aantalGrunt;
    private static int aantalHeavy;
    private static int aantalScherpschutters;
    private static int aantalSpeedy;
    private static int aantalTegenstanders;

    public Level(int aantalGrunt, int aantalHeavy, int aantalScherpschutters, int aantalSpeedy) {
        this.aantalGrunt = aantalGrunt;
        this.aantalHeavy = aantalHeavy;
        this.aantalScherpschutters = aantalScherpschutters;
        this.aantalSpeedy = aantalSpeedy;
        this.aantalTegenstanders = aantalGrunt + aantalHeavy + aantalScherpschutters + aantalSpeedy;
    }

    public int getAantalTegenstanders() {
        return aantalTegenstanders;
    }

    public static ArrayList<Tegenstander> createEnemies(double width, double height, Speler speler, ScoreText scoreText) {
        int n;
        ArrayList<Tegenstander> tegenstanders = new ArrayList<>(); // Create new ArrayList
        int totalEnemies = 50;
        for (int i = 0; i < totalEnemies; i++) {
            n = Random(4);
            if (n == 0 && aantalGrunt > 0) {
                tegenstanders.add(new Grunt(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
                aantalGrunt--;
                aantalTegenstanders--;
            } else if (n == 1 && aantalSpeedy > 0) {
                tegenstanders.add(new Speedy(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
                aantalSpeedy--;
                aantalTegenstanders--;
            } else if (n == 2 && aantalHeavy > 0) {
                tegenstanders.add(new Heavy(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
                aantalHeavy--;
                aantalTegenstanders--;
            } else if (n == 3 && aantalScherpschutters > 0) {
                tegenstanders.add(new Sluipschutter(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
                aantalScherpschutters--;
                aantalTegenstanders--;
            }
            System.out.println("Grunt: " + aantalGrunt);
            System.out.println("Heavy: " + aantalHeavy);
            System.out.println("Scherpschutters: " + aantalScherpschutters);
            System.out.println("Speedy: " + aantalSpeedy);
            System.out.println("Total Enemies: " + aantalTegenstanders);
        }

        if (aantalTegenstanders == 0) {
            //boolean boss = SetBoss();
            //Spelscherm.MaakBossAan(boss,speler,scoreText);
        }

        return tegenstanders;
    }

    private static int Random(int maxgetal) {
        Random r = new Random();
        int n = r.nextInt(maxgetal);
        return n;
    }

    public int getHuidigeTegenstanders() {
        return huidigeTegenstanders;
    }

    public void setHuidigeTegenstanders(int huidig) {
        huidigeTegenstanders = huidig;
    }

    //private boolean SetBoss() {
    //boolean boss = true;
}




