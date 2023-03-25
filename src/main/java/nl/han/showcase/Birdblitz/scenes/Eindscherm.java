package nl.han.showcase.Birdblitz.scenes;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.Birdblitz.Birdblitz;
import nl.han.showcase.Birdblitz.buttons.Startknop;
import nl.han.showcase.Birdblitz.entities.text.ScoreText;


public class Eindscherm extends StaticScene{

    private Birdblitz birdblitz;


    public Eindscherm(Birdblitz birdblitz) {
        this.birdblitz = birdblitz;
    }

    @Override
    public void setupScene() {
    }

    @Override
    public void setupEntities() {
        var BirdblitzText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game over"
        );
        BirdblitzText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        BirdblitzText.setFill(Color.DARKBLUE);
        BirdblitzText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(BirdblitzText);


        var BirdblitzMenuknop = new Startknop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
        BirdblitzMenuknop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(BirdblitzMenuknop);


        var Scoretext = new ScoreText(new Coordinate2D(getWidth()/2,950));
        addEntity(Scoretext);
        Scoretext.setScoreText();
    }
}
