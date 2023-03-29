package nl.han.showcase.Birdblitz.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.Birdblitz.scenes.Spelscherm;

public class LevensText extends TextEntity{

	public LevensText(Coordinate2D locatie) {
		super(locatie);
		setFont(Font.font("Roboto",FontWeight.NORMAL, 30));
	    setFill(Color.LIMEGREEN);
	}
	
	public void setLevensText(int levens) {
		setText("Levens: " + levens);
		if (levens <= 0){
			Spelscherm.EndGame();}
	}
	
	public void setLevensText() {
		setText("Levens");
	}


}
