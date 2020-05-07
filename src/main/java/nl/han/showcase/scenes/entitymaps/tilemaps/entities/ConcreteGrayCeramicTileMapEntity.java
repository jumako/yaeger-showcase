package nl.han.showcase.scenes.entitymaps.tilemaps.entities;

import com.github.hanyaeger.api.engine.Size;
import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.sprite.SpriteEntity;

public class ConcreteGrayCeramicTileMapEntity extends SpriteEntity {

    public ConcreteGrayCeramicTileMapEntity(Location location, Size size) {
        super("entities/concrete-gray-ceramic.jpeg", location, size);
    }
}
