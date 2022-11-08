package com.example.mynotes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Login {
    public Hyperlink newUser;

    public void newListener(ActionEvent actionEvent) throws IOException {
        Stage st=(Stage)newUser.getScene().getWindow();
        Parent root=FXMLLoader.load(getClass().getResource("signup.fxml"));
        st.setScene(new Scene(root));
    }

    public void onClick(ActionEvent actionEvent)
    {

    }
}
