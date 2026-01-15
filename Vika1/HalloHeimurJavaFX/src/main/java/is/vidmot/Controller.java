package is.vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *  Lýsing  : Controller eða stýring fyrir notendaviðmótið
 *
 *
 *****************************************************************************/
public class Controller {

    @FXML
    private Label welcomeText; // Viðmótshlutur sem geymir texta með kveðju

    @FXML
    /**
     * Birtir texta sem viðbragð við atburði frá hnappi
     */
    protected void onHelloButtonClick() {
        welcomeText.setText("Halló Freydís!");
    }
}

