package com.example.dialogdemo.vidmot;

import com.example.dialogdemo.vinnsla.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import java.util.Optional;

public class MainController {

    @FXML
    private ListView<String> listView; // Hér hefði mátt setja ListView<Person>

     public void onAdd(ActionEvent actionEvent) {

        Dialog<Person> personDialog = new PersonDialog(new Person("", ""));
        // opnar dialogin í personDialog og fær til baka svarið í result
        Optional<Person> result = personDialog.showAndWait();
        if (result.isPresent()) {
            ///  ýtt var á ok hnappinn
            Person person = result.get();
            listView.getItems().add(person+"");
        }
    }
}
