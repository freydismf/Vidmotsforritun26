package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Objects;

/**
 * Stýriklasi sem sýnir hvernig hægt er að breyta lögun viðmótshlutar. Það gildir
 * fyrir alla hluti sem erfa frá Region.
 *
 * @author Ebba Þóra Hvannberg
 */

public class ShapeController {
    @FXML
    private Button fxHnappurHI;
    @FXML
    private Button fxHnappur;

    /**
     * Setur lögunina á hnappnum sem hring og setur bakgrunn á hnappnum rauðan
     *
     * @param actionEvent
     */
    public void fxYtaHandler(ActionEvent actionEvent) {
        Circle hringur = new Circle(fxHnappur.getWidth());  // breidd hringsins skiptir ekki máli
        fxHnappur.setShape(hringur);
        // CorderRadii og Insets eru ekki notaðar í bakgrunninum
        fxHnappur.setBackground(new Background(new BackgroundFill(Color.RED,
                CornerRadii.EMPTY, Insets.EMPTY)));
        fxHnappur.setText("");
    }

    /**
     * Setur bakgrunninn sem mynd af HÍ lógóinu þegar ýtt er á hnappinn
     * @param actionEvent
     */
    public void fxYtaHI(ActionEvent actionEvent) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("PNG/HI.png")));
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        fxHnappurHI.setBackground(new Background(backgroundImage));
    }
}
