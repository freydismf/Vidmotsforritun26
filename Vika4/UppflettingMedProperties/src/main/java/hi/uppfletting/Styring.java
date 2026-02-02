package hi.uppfletting;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.InputStream;

public class Styring {
    @FXML
    private Label nafn_ut;
    @FXML
    private Label skilabod;
    @FXML
    private TextField profnumer_inn;
    private Skraavinnsla skraavinnsla;

    @FXML
    private void initialize() {
        nafn_ut.setText("");
        skilabod.setText("");
        InputStream is = getClass().getResourceAsStream("profnr.tsv");
        skraavinnsla = new Skraavinnsla(is);

        //  mjög einföld skilaboð
        //  skilabod.textProperty().bind (skraavinnsla.nidurstadaProperty());

        // Reglan sett upp fyrir skilaboðasviðið
        skilabod.textProperty().bind(
                Bindings.when(skraavinnsla.profnumerProperty().isEmpty())
                        .then(
                                "").
                        otherwise(
                                Bindings.when(skraavinnsla.giltProfnumerProperty().not()).then(
                                                "Ólöglegt prófnúmer")
                                        .otherwise(
                                                Bindings.concat(
                                                        "Nemandi með prófnúmer ",
                                                        skraavinnsla.profnumerProperty(),
                                                        Bindings.when(
                                                                        skraavinnsla.nidurstadaProperty().isEmpty())
                                                                .then(" fannst ekki")
                                                                .otherwise(
                                                                        Bindings.concat(" er ", skraavinnsla.nidurstadaProperty()
                                                                        ))
                                                )
                                        )
                        )
        );

    }

    @FXML
    private void lesa_profnumer() {

        String profnr = profnumer_inn.getText();
        /** fært í Skráavinnsla
         if (!profnr.matches("\\d{4}")) {
         skilabod.setText("Prófnúmer verður að vera 4 tölustafir");
         nafn_ut.setText("");
         return;
         }
         **/
        // String nafn = skraavinnsla.finnaNafn(profnr);

        // Með properties - fallið skilar engu, viðmót uppfærist í gegnum reglur
        skraavinnsla.finnaNafn(profnr);

        /**
         if (nafn == null) {
         skilabod.setText("Prófnúmer fannst ekki");
         nafn_ut.setText("");
         } else {
         skilabod.setText("Nemandi með prófnúmer " + profnr + " er:");
         nafn_ut.setText(nafn);
         }
         **/
    }
}
