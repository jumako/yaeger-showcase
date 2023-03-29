package nl.han.showcase.Birdblitz.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.showcase.Birdblitz.Birdblitz;

public class Menuknop extends TextEntity implements MouseButtonPressedListener {

    private Birdblitz birdblitz;

    public Menuknop(Coordinate2D initialLocation, Birdblitz birdblitz) {
        super(initialLocation, "Ga naar menu");
        this.birdblitz = birdblitz;
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }



    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
        birdblitz.setActiveScene(0);

    }

}
