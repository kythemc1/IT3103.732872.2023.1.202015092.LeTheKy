module com.example.aimsproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.aimsproject to javafx.fxml;
    exports com.example.aimsproject;
}