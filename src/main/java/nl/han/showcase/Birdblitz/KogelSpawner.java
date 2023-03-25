package nl.han.showcase.Birdblitz;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.showcase.Birdblitz.entities.Kogel;


public class KogelSpawner extends EntitySpawner{

    private Coordinate2D kogelLocatie;

    public KogelSpawner(long intervalInMs) {
        super(300);
        pause();
    }

    @Override
    protected void spawnEntities() {
        var kogel = new Kogel(kogelLocatie);
        System.out.println(kogelLocatie);
        spawn(kogel);
    }

    public void setLocatie(Coordinate2D locatie) {
        this.kogelLocatie = locatie;
    }


}
