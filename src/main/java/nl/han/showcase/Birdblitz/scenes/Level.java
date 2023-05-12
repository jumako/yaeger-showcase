package nl.han.showcase.Birdblitz.scenes;

;
import com.github.hanyaeger.api.Coordinate2D;
import nl.han.showcase.Birdblitz.entities.*;
import nl.han.showcase.Birdblitz.entities.text.KillText;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;

import java.util.ArrayList;
import java.util.Collections;
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
    private static final int gruntNummer = 1;
    private static final int speedyNummer = 2;
    private static final int heavyNummer=3;
    private static final int scherpschutterNummer=4;

    public Level(int aantalGrunt, int aantalHeavy, int aantalScherpschutters, int aantalSpeedy) {
        this.aantalGrunt = aantalGrunt;
        this.aantalHeavy = aantalHeavy;
        this.aantalScherpschutters = aantalScherpschutters;
        this.aantalSpeedy = aantalSpeedy;
    }

    public static ArrayList<Tegenstander> createEnemies(double width, double height, Speler speler, ScoreText scoreText) {
        ArrayList<Integer> tegenstandersNummers = new ArrayList<>();
        ArrayList<Tegenstander> tegenstanders = new ArrayList<>();
        for (int i = 0; i < aantalGrunt;i++){
            tegenstandersNummers.add(gruntNummer);
        }
        for (int i = 0; i < aantalHeavy;i++){
            tegenstandersNummers.add(heavyNummer);
        }
        for (int i = 0; i < aantalScherpschutters;i++){
            tegenstandersNummers.add(scherpschutterNummer);
        }
        for (int i = 0; i < aantalSpeedy;i++){
            tegenstandersNummers.add(speedyNummer);
        }
       shuffleArrayList(tegenstandersNummers);
        for (int i = 0; i < tegenstandersNummers.size(); i++) {
            System.out.println(tegenstandersNummers.get(i));
        }
        for (int i = 0; i < tegenstandersNummers.size(); i++) {
            int nummer = tegenstandersNummers.get(i);
            int aantalTegenstanders = Tegenstander.aantalTegenstanders;
            if (aantalTegenstanders <= 4){
            if (nummer == 1) {
                tegenstanders.add(new Grunt(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
            } else if (nummer == 2) {
                tegenstanders.add(new Speedy(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
            } else if (nummer == 3) {
                tegenstanders.add(new Heavy(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
            } else if (nummer == 4) {
                tegenstanders.add(new Sluipschutter(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
            }
        }
        }
        System.out.println("Grunt: " + aantalGrunt);
        System.out.println("Heavy: " + aantalHeavy);
        System.out.println("Scherpschutters: " + aantalScherpschutters);
        System.out.println("Speedy: " + aantalSpeedy);
        System.out.println("Total Enemies: " + tegenstandersNummers.size());
        System.out.println(Tegenstander.aantalTegenstanders + "test");
        return tegenstanders;
    }


    private static int Random(int maxgetal) {
        Random r = new Random();
        int n = r.nextInt(maxgetal);
        return n;
    }

    public static void shuffleArrayList(ArrayList<?> list) {
        Collections.shuffle(list);
    }
}




