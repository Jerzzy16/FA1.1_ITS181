module com.example.fa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.fa to javafx.fxml;
    exports com.example.fa;
    exports com.example.fa.Controller;
    opens com.example.fa.Controller to javafx.fxml;
}