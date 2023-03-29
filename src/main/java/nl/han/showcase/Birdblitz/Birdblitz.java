package nl.han.showcase.Birdblitz;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.showcase.Birdblitz.scenes.Eindscherm;
//import nl.han.showcase.Birdblitz.scenes.LevelMenu;
import nl.han.showcase.Birdblitz.scenes.Spelscherm;
import nl.han.showcase.Birdblitz.scenes.StartScherm;


public class Birdblitz extends YaegerGame {

    @Override
    public void setupGame() {
        setGameTitle("Birdblitz");
        setSize(new Size(800, 800));
    }

    @Override
    public void setupScenes() {
       addScene(0, new StartScherm(this));
       //addScene(1,new LevelMenu(this));
        addScene(1,new Spelscherm(this,1));
        addScene(2, new Eindscherm(this));
    }
}
