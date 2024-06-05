module com.example.fa1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fa1 to javafx.fxml;
    exports com.example.fa1;
}