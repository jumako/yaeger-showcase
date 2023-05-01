package nl.han.showcase.Birdblitz.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import nl.han.showcase.Birdblitz.Birdblitz;
import nl.han.showcase.Birdblitz.buttons.*;


public class StartScherm extends StaticScene {
    private Birdblitz birdblitz;

    public StartScherm(Birdblitz birdblitz) {
        this.birdblitz = birdblitz;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/StartScherm.png");
        setBackgroundAudio("audio/Angry-Birds-Theme-Song.mp3");

    }

    @Override
    public void setupEntities() {
        var BirdblitzStartknop = new Startknop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
        BirdblitzStartknop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(BirdblitzStartknop);
    }
}
