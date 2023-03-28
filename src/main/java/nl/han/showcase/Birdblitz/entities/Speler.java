package nl.han.showcase.Birdblitz.entities;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.showcase.Birdblitz.KogelSpawner;
import nl.han.showcase.Birdblitz.entities.text.LevensText;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;
import nl.han.showcase.Birdblitz.scenes.Spelscherm;

import java.util.Set;

public abstract class Speler extends DynamicSpriteEntity implements KeyListener,SceneBorderTouchingWatcher, Collided, UpdateExposer{
	
	private final LevensText levensText;
	private int levens = 150;
	private final ScoreText scoreText;
	private int score = 0;
	private final KogelSpawner kogelSpawner;
	private Spelscherm spelscherm;
	private Coordinate2D locatie;


	public Speler(Coordinate2D locatie, LevensText levensText,ScoreText scoreText, KogelSpawner kogelSpawner, Spelscherm spelscherm){
		super("entities/player.png", locatie, new Size(100,100), 1, 1);
		this.levensText = levensText;
		levensText.setLevensText(levens);
		this.scoreText = scoreText;
		scoreText.setScoreText(getScore());
		this.kogelSpawner = kogelSpawner;
		this.setSpelscherm(spelscherm);
	}

	@Override
	public void onCollision(Collider collidingObject) {
		if(collidingObject instanceof Tegenstander) {
			if(collidingObject instanceof Grunt) {
				levens = levens - Grunt.schade;
				System.out.println(Grunt.schade);
				levensText.setLevensText(levens);
				this.setScore(this.getScore() + Grunt.score);
				scoreText.setScoreText(this.getScore());
				checkAantalTegenstanders();
				((Tegenstander) collidingObject).remove();
			}
			if(collidingObject instanceof Speedy) {
				levens = levens - Speedy.schade;
				System.out.println(Speedy.schade);
				levensText.setLevensText(levens);
				this.setScore(this.getScore() + Speedy.score);
				scoreText.setScoreText(this.getScore());
				checkAantalTegenstanders();
				((Tegenstander) collidingObject).remove();
			}
			if(collidingObject instanceof Heavy) {
				levens = levens - Heavy.schade;
				System.out.println(Heavy.schade);
				levensText.setLevensText(levens);
				this.setScore(this.getScore() + Heavy.score);
				scoreText.setScoreText(this.getScore());
				checkAantalTegenstanders();
				((Tegenstander) collidingObject).remove();
			}
	if(collidingObject instanceof Sluipschutter) {
				System.out.println(Sluipschutter.schade);
				levensText.setLevensText(levens);
				this.setScore(this.getScore() + Sluipschutter.score);
				scoreText.setScoreText(this.getScore());
				checkAantalTegenstanders();
				((Tegenstander) collidingObject).remove();
			}
		}
		
	}

	@Override
	public void notifyBoundaryTouching(SceneBorder border) {
		setSpeed(0);
		
		switch(border){
        case LEFT:
            setAnchorLocationX(1);
            break;
        case RIGHT:
            setAnchorLocationX(getSceneWidth() - getWidth() - 1);
        default:
            break;
        }
	}



	@Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
        } else if(!pressedKeys.contains(KeyCode.LEFT) || !pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(0,0d);
        }
        else {
            setMotion(0,0d);
        }
        spatieIngedrukt(pressedKeys);
    }
    
    public void spatieIngedrukt(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.SPACE)){
            kogelSpawner.resume();
        }else {
            kogelSpawner.pause();
        }
    }
	
	public Coordinate2D getSpelerLocatie() {
        Coordinate2D spelerLocatie;

        spelerLocatie = this.getLocationInScene();

        return spelerLocatie;
    }

	public void spelerDestroyedEnemy (){

	}

//	public spelerUpgrade1(Coordinate2D locatie, LevensText levensText, ScoreText scoreText, KogelSpawner kogelSpawner, Spelscherm spelscherm){
//		super("entities/playercharacterupgrade1.png", locatie, new Size(100,100), 1, 1);
//		this.levensText = levensText;
//		levensText.setLevensText(levens);
//		this.scoreText = scoreText;
//		scoreText.setScoreText(getScore());
//		this.kogelSpawner = kogelSpawner;
//		this.setSpelscherm(spelscherm);
//	}

	public void spelerDestroyedEnemy(Tegenstander tegenstander) {
		if (tegenstander instanceof Grunt) {
			this.setImage("entities/playercharacterupgrade1.png");
			this.levens = 150;
			this.setScore(this.getScore() + 5);
			set.mo
			levensText.setLevensText(levens);
			scoreText.setScoreText(this.getScore());
		} else if (tegenstander instanceof Speedy) {
			this.levens += 20;
			this.setScore(this.getScore() + 10);
			this.setImage("entities/player3.png");
			levensText.setLevensText(levens);
			scoreText.setScoreText(this.getScore());
		} else if (tegenstander instanceof Heavy) {
			this.levens += 30;
			this.setScore(this.getScore() + 15);
			this.setImage("entities/player4.png");
			levensText.setLevensText(levens);
			scoreText.setScoreText(this.getScore());
		} else if (tegenstander instanceof Sluipschutter) {
			this.levens += 40;
			this.setScore(this.getScore() + 20);
			this.setImage("entities/player5.png");
			levensText.setLevensText(levens);
			scoreText.setScoreText(this.getScore());
		}
	}

	public void setSpelscherm(Spelscherm spelscherm) {
		this.spelscherm = spelscherm;
	}

	public Spelscherm getSpelscherm() {
		return spelscherm;
	}

	private void checkAantalTegenstanders() {
		if (getSpelscherm().getAantalTegenstanders() == 0) {
			getSpelscherm().spelerGewonnen();
		}
	}

	public int getLevens() {
		return levens;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
