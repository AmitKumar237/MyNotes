package com.example.mynotes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {
    public Hyperlink reg;
    public void regListener(ActionEvent actionEvent)throws IOException {
        Stage st=(Stage) reg.getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("login.fxml"));
        st.setScene(new Scene(root));
    }
}
