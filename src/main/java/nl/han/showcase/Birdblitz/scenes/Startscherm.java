package nl.han.showcase.Birdblitz.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import nl.han.showcase.Birdblitz.Birdblitz;

public class Startscherm extends StaticScene {
    private Birdblitz birdblitz;

    public Startscherm(Birdblitz birdblitz) {
        this.birdblitz = birdblitz;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/StartScherm.png");

    }

    @Override
    public void setupEntities() {

    }
}
