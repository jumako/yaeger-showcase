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
    private static final int gruntNummer = 0;
    private static final int speedyNummer = 1;
    private static final int heavyNummer=2;
    private static final int scherpschutterNummer=3;

    public Level(int aantalGrunt, int aantalHeavy, int aantalScherpschutters, int aantalSpeedy) {
        this.aantalGrunt = aantalGrunt;
        this.aantalHeavy = aantalHeavy;
        this.aantalScherpschutters = aantalScherpschutters;
        this.aantalSpeedy = aantalSpeedy;
        this.aantalTegenstanders = aantalGrunt + aantalHeavy + aantalScherpschutters + aantalSpeedy;
    }

    public static ArrayList<Tegenstander> createEnemies(double width, double height, Speler speler, ScoreText scoreText) {
        ArrayList<Tegenstander> tegenstandersNummers = new ArrayList<>();
        ArrayList<Tegenstander> array = tegenstandersNummers;
        array = vulArray(aantalGrunt, gruntNummer, array);
        array = vulArray(aantalHeavy, heavyNummer, array);
        array = vulArray(aantalScherpschutters, scherpschutterNummer, array);
        array = vulArray(aantalSpeedy, speedyNummer, array);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        ArrayList<Tegenstander> tegenstanders = new ArrayList<>();
        for (int i = 0; i < tegenstandersNummers.size(); i++) {
            int tegenstanderNummer = tegenstandersNummers.get(i);
            if (tegenstanderNummer == 0) {
                tegenstanders.add(new Grunt(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
            } else if (tegenstanderNummer == 1) {
                tegenstanders.add(new Speedy(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
            } else if (tegenstanderNummer == 2) {
                tegenstanders.add(new Heavy(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
            } else if (tegenstanderNummer == 3) {
                tegenstanders.add(new Sluipschutter(new Coordinate2D(Random(700) + 20, height), speler, scoreText));
            }
        }
        System.out.println("Grunt: " + aantalGrunt);
        System.out.println("Heavy: " + aantalHeavy);
        System.out.println("Scherpschutters: " + aantalScherpschutters);
        System.out.println("Speedy: " + aantalSpeedy);
        System.out.println("Total Enemies: " + tegenstandersNummers.size());

        //if () {
        //boolean boss = SetBoss();
        //Spelscherm.MaakBossAan(boss,speler,scoreText);
        //}

        return tegenstanders;
    }


    private static int Random(int maxgetal) {
        Random r = new Random();
        int n = r.nextInt(maxgetal);
        return n;
    }

    private static ArrayList vulArray(int aantalSoortVogel,int soortNummer,ArrayList array){
        for (int i = 0; i < aantalSoortVogel;i++){
            array.add(soortNummer);

        }
        return array;
    }
}




