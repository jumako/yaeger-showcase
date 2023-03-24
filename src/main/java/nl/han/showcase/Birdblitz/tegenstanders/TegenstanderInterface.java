package nl.han.showcase.Birdblitz.tegenstanders;

import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public interface TegenstanderInterface extends Collided, Collider, SceneBorderCrossingWatcher, UpdateExposer {

        void notifyBoundaryCrossing(SceneBorder border);

        void explicitUpdate(long timestamp);

        void Beweeg();

    }
