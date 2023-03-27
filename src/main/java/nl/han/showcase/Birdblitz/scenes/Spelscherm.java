package nl.han.showcase.Birdblitz.scenes;

import java.util.ArrayList;
import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMap;
import nl.han.showcase.Birdblitz.Birdblitz;
import nl.han.showcase.Birdblitz.KogelSpawner;
import nl.han.showcase.Birdblitz.entities.*;
import nl.han.showcase.Birdblitz.entities.text.LevensText;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;


public class Spelscherm extends DynamicScene implements EntitySpawnerContainer{

    //private Speler speler;
    private KogelSpawner kogelSpawner;
    private Birdblitz birdblitz;
    public int huidigeTegenstanders;
    public int ronde;

    public Spelscherm(Birdblitz birdblitz ) {
        this.birdblitz = birdblitz;
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
        if(ronde > 5) {
            birdblitz.setActiveScene(2);
        }
        if(ronde == 5) {
            Boss boss = new Boss(new Coordinate2D(getWidth()/2, getHeight() / 12), speler, scoreText);
            addEntity(boss);
        }
        else {
            int max = 6;
            ArrayList<Tegenstander> tegenstanders = new ArrayList<>();
            for(huidigeTegenstanders = 0; huidigeTegenstanders < max; huidigeTegenstanders++) {
                int ruimte = huidigeTegenstanders * 70;

                //Random r = new Random();
                //int n = r.nextInt(4) + 1;
                int n = 4;

                if(n == 1) {
                    tegenstanders.add(new Grunt(new Coordinate2D(getWidth()/4 + ruimte , getHeight() / 12), speler, scoreText));
                }
                if(n == 2) {
                    tegenstanders.add(new Speedy(new Coordinate2D(getWidth()/4 + ruimte, getHeight() / 12), speler, scoreText));
                }
                if(n == 3) {
                    tegenstanders.add(new Heavy(new Coordinate2D(getWidth()/4 + ruimte , getHeight() / 12), speler, scoreText));
                }
                if(n == 4) {
                    tegenstanders.add(new Scherpschutten2(new Coordinate2D(getWidth() / 4 + ruimte, getHeight() / 12), speler, scoreText,kogelSpawner) {



                    });
                }
            }
            for(Tegenstander t : tegenstanders) {
                addEntity(t);
            }
            ronde++;
            System.out.println("Gemaakte tegenstanders: " + huidigeTegenstanders);
        }
    }
    public void setHuidigeTegenstanders(int huidig) {
        huidigeTegenstanders = huidig;
    }

    public int getHuidigeTegenstanders() {
        return huidigeTegenstanders;
    }



}