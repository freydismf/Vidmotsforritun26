module com.example.dialogdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dialogdemo to javafx.fxml;
    exports com.example.dialogdemo;
    exports com.example.vinnsla;
    opens com.example.vinnsla to javafx.fxml;
}