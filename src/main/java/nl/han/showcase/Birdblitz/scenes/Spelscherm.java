package nl.han.showcase.Birdblitz.scenes;

import java.util.ArrayList;
import java.util.Random;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.birdblitz.KogelSpawner;
import com.github.hanyaeger.birdblitz.birdblitz;
import com.github.hanyaeger.birdblitz.entities.speedy;
import com.github.hanyaeger.birdblitz.entities.boss;
import com.github.hanyaeger.birdblitz.entities.grunt;
import com.github.hanyaeger.birdblitz.entities.Speler;
import com.github.hanyaeger.birdblitz.entities.heavy;
import com.github.hanyaeger.birdblitz.entities.Tegenstander;
import com.github.hanyaeger.birdblitz.entities.text.LevensText;
import com.github.hanyaeger.birdblitz.entities.text.ScoreText;


public class Spelscherm extends DynamicScene implements EntitySpawnerContainer{

    //private Speler speler;
    private KogelSpawner kogelSpawner;
    private birdblitz birdblitz;
    public int huidigeTegenstanders;
    public int ronde;

    public Spelscherm(birdblitz birdblitz) {
        this.birdblitz = birdblitz;
    }

    @Override
    public void setupScene() {
        // TODO Auto-generated method stub
        setBackgroundImage("backgrounds/space.jpg");
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
            boss boss = new boss(new Coordinate2D(getWidth()/2, getHeight() / 12), speler, scoreText);
            addEntity(boss);
        }
        else {
            int max = 6;
            ArrayList<Tegenstander> tegenstanders = new ArrayList<>();
            for(huidigeTegenstanders = 0; huidigeTegenstanders < max; huidigeTegenstanders++) {
                int ruimte = huidigeTegenstanders * 70;

                Random r = new Random();
                int n = r.nextInt(3) + 1;

                if(n == 1) {
                    tegenstanders.add(new grunt(new Coordinate2D(getWidth()/4 + ruimte , getHeight() / 12), speler, scoreText));
                }
                if(n == 2) {
                    tegenstanders.add(new speedy(new Coordinate2D(getWidth()/4 + ruimte, getHeight() / 12), speler, scoreText));
                }
                if(n == 3) {
                    tegenstanders.add(new heavy(new Coordinate2D(getWidth()/4 + ruimte , getHeight() / 12), speler, scoreText));
                }
            }
            for(Tegenstander t : tegenstanders) {
                addEntity(t);
            }
            ronde++;
            System.out.println("Gemaakte tegenstanders: " + huidigeTegenstanders);
        }
    }