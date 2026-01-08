package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *  Lýsing  : Einfalt aðalforrit fyrir Halló heimur appið í JavaFX
 *
 *
 *****************************************************************************/
public class HalloHeimurApp extends javafx.application.Application {

    /**
     * Ræsir appið
     *
     * @param stage glugginn
     * @throws Exception undnantekning sem verður ef villla
     */
    @Override
    public void start(Stage stage) throws Exception {

        // Smíða loader fyrir notendaviðmótið sem er geymt í skránni hello-view.fxml
        // Gætið þess að .fxml skráin sé undir resources/is/vidmot
           FXMLLoader fxmlLoader = new FXMLLoader(HalloHeimurApp.class.getResource("hello-view.fxml"));
        // Smíða senuna með notendaviðmótinu sem er núna lesið inn af resources
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        // Setja titilinn á gluggann
        stage.setTitle("Halló heimur");
        // Tengja senuna við glugggann
        stage.setScene(scene);
        // Birta gluggann
        stage.show();

    }

    /**
     * Aðalforritið sem ræsir appið
     *
     * @param args
     */
    public static void main(String[] args) {
        // Ræsa forritið
        launch();
    }
}
