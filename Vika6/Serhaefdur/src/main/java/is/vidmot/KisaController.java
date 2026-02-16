package is.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.InputStream;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Controller fyrir kisuforrit - getur eytt út myndum og sett inn nýja mynd
 *
 *****************************************************************************/

public class KisaController {
    @FXML
    private HBox fxKisur;

    private final Image[] myndir = new Image[3];




    /**
     * Upphafsstillir 3 nýjar kisumyndir
     */
    @FXML
    public void initialize() {
        lesaMyndir();
        for (int i = 0; i < fxKisur.getChildren().size(); i++) {
            ((DyrSpjald) fxKisur.getChildren().get(i)).setDyrMynd(myndir[i]);
        }
    }

    /**
     * Les kisumyndir inn
     */
    private void lesaMyndir() {
        for (int i = 0; i < myndir.length; i++) {
            String nafn = "myndir/kisa" + (i + 1) + ".jpg";
            InputStream is = DyrSpjald.class.getResourceAsStream(nafn);
            if (is == null) {
                System.out.println("Fann ekki myndina: " + nafn);
            } else {
                myndir[i] = new Image(is);
            }
        }
    }

    /**
     * Setur nýja mynd af kisu af handahófi í myndaramma af handahófi
     * Ef enginn kisumynd er sýnileg þá eru þær upphafsstilltar
     *
     * @param actionEvent ónotað
     */
    @FXML
    public void nyKisaHandler(ActionEvent actionEvent) {
        // setja kisumynd af handahófi á DyrSpjald "ramma" af handahófi
        int i = (int) (Math.random() * 3);
        int j = (int) (Math.random() * 3);
        ((DyrSpjald) fxKisur.getChildren().get(i)).setDyrMynd(myndir[j]);
    }

}
