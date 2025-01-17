package nl.han.showcase.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.showcase.YaegerShowCase;
import nl.han.showcase.shared.buttons.BackButton;

import java.util.Set;

/**
 * Because all scenes from the showcase look partially similar, this abstract superclass
 * encapsulates that part of the behaviour.
 */
public abstract class ShowCaseScene extends DynamicScene implements KeyListener {

    public static final double BOTTOM_MARGIN = 30;
    protected YaegerShowCase showCase;

    public ShowCaseScene(final YaegerShowCase yaegerShowCase) {
        this.showCase = yaegerShowCase;
    }

    @Override
    public void setupEntities() {
        var backButton = new BackButton(getHeight() - BOTTOM_MARGIN, showCase);
        addEntity(backButton);
    }

    @Override
    public void onPressedKeysChange(final Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.DIGIT0)) {
            showCase.setActiveScene(YaegerShowCase.SCENE_SELECTION);
        }
    }
}
