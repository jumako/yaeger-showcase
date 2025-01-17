package nl.han.showcase.shared.textfield;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.text.Font;
import nl.han.showcase.YaegerShowCase;

/**
 * A reusable component of an outlined text-field that contains both a label and a value. The value
 * is exposed through the {@link #setValue(String)} method.
 */
public class DynamicShowCaseTextField extends DynamicCompositeEntity {

    private final String name;
    private String defaultValue;
    private TextEntity value;

    public DynamicShowCaseTextField(final Coordinate2D initialLocation, final String name) {
        this(initialLocation, name, "");
    }

    public DynamicShowCaseTextField(final Coordinate2D initialLocation, final String name, final String defaultValue) {
        super(initialLocation);
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    protected void setupEntities() {
        // The background is a black rectangle with a HAN-red stroke
        addEntity(new TextFieldBackground(new Coordinate2D(0, 8), new Size(100, 30)));

        // The Line blocker places a small black rectangle over the stroke of the background. The length of
        // the name (e.g. number of characters) is used to calculate the length of this rectangle.
        addEntity(new LineBlocker(new Coordinate2D(6, 8), name.length() * 5));

        // For the fieldName we create a TextEntity and pass the name from the constructor
        var fieldName = new TextEntity(new Coordinate2D(8, 2), name);
        fieldName.setAnchorPoint(AnchorPoint.TOP_LEFT);
        fieldName.setFont(Font.font("Roboto", 10));
        fieldName.setFill(YaegerShowCase.HAN_RED);
        addEntity(fieldName);

        // The actual text will be displayed using a TextEntity, which is created as am instance variable, so
        // the setValue(String) method can change the displayed text
        value = new TextEntity(new Coordinate2D(8, 16), defaultValue);
        value.setAnchorPoint(AnchorPoint.TOP_LEFT);
        value.setFont(Font.font("Roboto", 12));
        value.setFill(YaegerShowCase.HAN_RED);
        addEntity(value);
    }

    public void setValue(String fieldValue) {
        value.setText(fieldValue);
    }
}
