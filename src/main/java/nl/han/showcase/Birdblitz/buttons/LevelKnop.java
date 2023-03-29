package nl.han.showcase.Birdblitz.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class LevelKnop extends TextEntity implements MouseButtonPressedListener {

    public LevelKnop(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {

    }
}
