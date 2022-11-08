module com.example.mynotes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mynotes to javafx.fxml;
    exports com.example.mynotes;
}