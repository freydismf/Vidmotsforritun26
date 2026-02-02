module hi.vidmot.uppfletting {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.uppfletting to javafx.fxml;
    exports hi.uppfletting;
}