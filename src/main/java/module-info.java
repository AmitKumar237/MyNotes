module com.example.mynotes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mynotes to javafx.fxml;
    exports com.example.mynotes;
}