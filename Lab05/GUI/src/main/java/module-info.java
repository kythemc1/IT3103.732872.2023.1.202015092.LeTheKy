module com.example.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens com.example.gui to javafx.fxml;
    exports com.example.gui;
}