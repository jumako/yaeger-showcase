package nl.han.showcase.Birdblitz.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ScoreText extends TextEntity{
	
	public int huidigeScore;
	
	public ScoreText(Coordinate2D locatie) {
		super(locatie);
		setFont(Font.font("Roboto",FontWeight.NORMAL, 30));
	    setFill(Color.LIMEGREEN);
	}
	
	public void setScoreText(int huidigeScore) {
		setText(huidigeScore+ " :Score");
	}
	
	public void setScoreText() {
		setText("Score");
	}

}
