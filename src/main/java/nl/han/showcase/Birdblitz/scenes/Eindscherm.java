package nl.han.showcase.Birdblitz.scenes;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import nl.han.showcase.Birdblitz.Birdblitz;
import nl.han.showcase.Birdblitz.buttons.Menuknop;



public class Eindscherm extends StaticScene{

    private Birdblitz birdblitz;


    public Eindscherm(Birdblitz birdblitz) {
        this.birdblitz = birdblitz;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/EindScherm.png");
    }

    @Override
    public void setupEntities() {
        var BirdblitzMenuknop = new Menuknop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
        BirdblitzMenuknop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(BirdblitzMenuknop);
    }
}

