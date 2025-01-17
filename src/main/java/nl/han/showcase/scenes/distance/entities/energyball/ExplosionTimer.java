package nl.han.showcase.scenes.distance.entities.energyball;

import com.github.hanyaeger.api.Timer;

public class ExplosionTimer extends Timer {

    private Explosion explosion;

    public ExplosionTimer(final Explosion explosion) {
        super(40);
        this.explosion = explosion;
    }

    @Override
    public void onAnimationUpdate(final long timestamp) {
        explosion.updateFrame();
    }
}
