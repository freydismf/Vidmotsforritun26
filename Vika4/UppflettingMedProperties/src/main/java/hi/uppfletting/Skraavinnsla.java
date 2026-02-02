package hi.uppfletting;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Skraavinnsla {
    private final Map<String, String> prof2nafn = new HashMap<>();

    /**
     * setjum upp þrjár tilviksbreytur sem eru vaktaðar af stýringunni
     */
    private final SimpleStringProperty nidurstada = new SimpleStringProperty("");
    private SimpleStringProperty profnumer = new SimpleStringProperty("");
    private BooleanBinding giltProfnumer = Bindings.createBooleanBinding(()->
            profnumer.get().matches ("\\d{4}") ,profnumer);


    public Skraavinnsla(InputStream in) {
        if (in == null) {
            throw new IllegalArgumentException("profnr.tsv not found (InputStream is null)");
        }
        lesa_skra(in);
    }
    private void lesa_skra(InputStream in) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(in, StandardCharsets.UTF_8))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (line.isBlank()) continue;
                if (line.startsWith("#")) continue; // allow comments
                String[] p = line.split("\t", 2);
                if (p.length < 2) continue; // skip malformed lines
                prof2nafn.put(p[0].trim(), p[1].trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/**
    public String finnaNafn(String profnr) {
        if (profnr == null) return null;
        return prof2nafn.get(profnr);
    }
**/
   // hér er útfærslan á finnaNafn með properties

    public void finnaNafn(String profnr) {

        this.profnumer.set(profnr);
        nidurstada.set (prof2nafn.get(profnr));
    }

    public SimpleStringProperty nidurstadaProperty() {
        return nidurstada;
    }

    public SimpleStringProperty profnumerProperty() {
        return profnumer;
    }

    public BooleanBinding giltProfnumerProperty() {
        return giltProfnumer;
    }
}