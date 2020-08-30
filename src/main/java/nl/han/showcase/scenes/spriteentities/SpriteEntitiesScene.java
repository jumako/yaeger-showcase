package nl.han.showcase.scenes.spriteentities;

import com.github.hanyaeger.api.engine.entities.entity.AnchorPoint;
import com.github.hanyaeger.api.engine.entities.entity.Coordinate2D;
import com.github.hanyaeger.api.engine.entities.entity.motion.Direction;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.buttons.BackButton;
import nl.han.showcase.scenes.ShowCaseScene;
import nl.han.showcase.scenes.spriteentities.entities.BasketBall;
import nl.han.showcase.scenes.spriteentities.entities.GolfBall;
import nl.han.showcase.scenes.spriteentities.entities.RugbyBall;
import nl.han.showcase.scenes.spriteentities.entities.TennisBall;

public class SpriteEntitiesScene extends ShowCaseScene {

    private YaegerShowCase showCase;

    public SpriteEntitiesScene(final YaegerShowCase showCase) {
        this.showCase = showCase;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/landscape.jpg");
    }

    @Override
    public void setupEntities() {

        var backButton = new BackButton(showCase, new Coordinate2D(20, getHeight() - 30));
        addEntity(backButton);

        placeRugbyBallOnWithAllAnchorPoints();

        var tennisBall = new TennisBall(new Coordinate2D(100, 120));
        addEntity(tennisBall);

        var basketBall = new BasketBall(new Coordinate2D(100, 220));
        addEntity(basketBall);


        var golfBall1 = new GolfBall(new Coordinate2D(getWidth() / 2, 420), 4, Direction.RIGHT.getValue());
        golfBall1.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(golfBall1);

        var golfBall2 = new GolfBall(new Coordinate2D(20, 420), 5, Direction.LEFT.getValue());
        golfBall2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(golfBall2);

        var golfBall3 = new GolfBall(new Coordinate2D(getWidth() - 20, 420), 6, Direction.RIGHT.getValue());
        golfBall3.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(golfBall3);
    }

    private void placeRugbyBallOnWithAllAnchorPoints() {
        var rugbyBallTL = new RugbyBall(new Coordinate2D(0, 0));
        addEntity(rugbyBallTL);

        var rugbyBallTC = new RugbyBall(new Coordinate2D(getWidth() / 2, 0));
        rugbyBallTC.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(rugbyBallTC);

        var rugbyBallTR = new RugbyBall(new Coordinate2D(getWidth(), 0));
        rugbyBallTR.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(rugbyBallTR);

        var rugbyBallLC = new RugbyBall(new Coordinate2D(0, getHeight() / 2));
        rugbyBallLC.setAnchorPoint(AnchorPoint.CENTER_LEFT);
        addEntity(rugbyBallLC);

        var rugbyBallCC = new RugbyBall(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        rugbyBallCC.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(rugbyBallCC);

        var rugbyBallRC = new RugbyBall(new Coordinate2D(getWidth(), getHeight() / 2));
        rugbyBallRC.setAnchorPoint(AnchorPoint.CENTER_RIGHT);
        addEntity(rugbyBallRC);

        var rugbyBallBL = new RugbyBall(new Coordinate2D(0, getHeight()));
        rugbyBallBL.setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        addEntity(rugbyBallBL);

        var rugbyBallBC = new RugbyBall(new Coordinate2D(getWidth() / 2, getHeight()));
        rugbyBallBC.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        addEntity(rugbyBallBC);

        var rugbyBallBR = new RugbyBall(new Coordinate2D(getWidth(), getHeight()));
        rugbyBallBR.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addEntity(rugbyBallBR);
    }

    @Override
    public YaegerShowCase getShowCase() {
        return showCase;
    }
}
