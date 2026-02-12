package is.vidmot;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import is.vinnsla.Leikmenn;

/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Controller fyrir sýnidæmi um dialog. Gerir ekkert nema
 *            setja upp dialoginn
 *
 *****************************************************************************/
public class AdalController {
    @FXML
    private Label fxLeik1;
    @FXML
    private Label fxLeik2;
    /**
     * Býr til dialog, opnar hann og fær gögn úr honum
     */
    public void initialize() {
        // Býr til dialog áður en gluggi þessa controller er sýndur
        // controllerinn er búinn til í forriti, en yfirleitt er hann búinn til
        // þegar .fxml skrá er lesin inn
        LeikmennDialogController d = new LeikmennDialogController();
        // birta dialog, ná í nöfn leikmanna og setja í tilviksbreytu
        Leikmenn leikmenn = d.getNofnLeikmanna();
        if (leikmenn != null) {
            fxLeik1.setText(leikmenn.getNafnLeikmanns1());
            fxLeik2.setText(leikmenn.getNafnLeikmanns2());
        }
        else {
            Platform.exit();
        }
    }
}
