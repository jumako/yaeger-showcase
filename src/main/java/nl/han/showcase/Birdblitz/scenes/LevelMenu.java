//package nl.han.showcase.Birdblitz.scenes;
//
//import com.github.hanyaeger.api.AnchorPoint;
//import com.github.hanyaeger.api.Coordinate2D;
//import com.github.hanyaeger.api.scenes.StaticScene;
//import nl.han.showcase.Birdblitz.Birdblitz;
//
//public class LevelMenu extends StaticScene {
//    private Birdblitz birdblitz;
//    public LevelMenu(Birdblitz birdblitz) {
//        this.birdblitz = birdblitz;
//    }
//
//    @Override
//    public void setupScene() {
//
//    }

//    @Override
//    public void setupEntities() {
//        var BirdblitzLevel1Knop = new Level1Knop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
//        BirdblitzLevel1Knop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(BirdblitzLevel1Knop);
//
//        var BirdblitzLevel2Knop = new Level2Knop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
//        BirdblitzLevel2Knop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(BirdblitzLevel2Knop);
//
//        var BirdblitzLevel3Knop = new Level3Knop(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 80), birdblitz);
//        BirdblitzLevel3Knop.setAnchorPoint(AnchorPoint.CENTER_CENTER);
//        addEntity(BirdblitzLevel3Knop);
//    }
//}
