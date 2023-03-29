package nl.han.showcase.Birdblitz.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.scenes.YaegerScene;
import nl.han.showcase.Birdblitz.Birdblitz;
import nl.han.showcase.Birdblitz.buttons.Startknop;

public class LevelMenu extends StaticScene {
    private Birdblitz birdblitz;
    public LevelMenu(Birdblitz birdblitz) {
        this.birdblitz = birdblitz;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var BirdblitzLevel1Knop = new LevelKnop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
        BirdblitzLevelKnop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(BirdblitzLevelKnop);

        var BirdblitzLevel2Knop = new Startknop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
        BirdblitzLevelKnop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(BirdblitzLevelKnop);

        var BirdblitzLevel3knop = new Startknop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
        BirdblitzStartknop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(BirdblitzStartknop);

    }
}
