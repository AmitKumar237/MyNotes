package com.example.mynotes;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;

public class SignUp {
    public Hyperlink reg;
    public TextField id;
    public TextField name;
    public TextField password;
    public Button signUp;
    public Label errorMessage;
    public void regListener(ActionEvent actionEvent)throws IOException {
        Stage st=(Stage) reg.getScene().getWindow();
        Parent root= FXMLLoader.load(getClass().getResource("login.fxml"));
        st.setScene(new Scene(root));
    }

    public void onClick(ActionEvent actionEvent)
    {
     String userName=name.getText();
     String userId=id.getText();
     String userPassword=password.getText();
     if(userName.equals("") || userId.equals("") || userPassword.equals(""))
     {
        errorMessage.setText("No Field should be empty!!");
     }
     else
     {
         JdbcConnection obj=new JdbcConnection();
         String q="insert into users(userId,name,password) values(?,?,?)";
         try {
             PreparedStatement ptsmt = obj.getConection().prepareStatement(q);
             ptsmt.setString(1,userId);
             ptsmt.setString(2,userName);
             ptsmt.setString(3,userPassword);
             int tmp = ptsmt.executeUpdate();

            //Redirecting to landingPage
             FXMLLoader loader = new FXMLLoader(getClass().getResource("landingPage.fxml"));
             Parent root = loader.load();

             LandingPage landingPage = loader.getController();
             landingPage.setUserTitle(userName,userId);

             Stage st=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
             Scene scene = new Scene(root);
             st.setScene(scene);
             st.show();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
     }


    }
}
