package com.example.mynotes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 320);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        JdbcConnection obj = new JdbcConnection();
        obj.createConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}