package com.example.mynotes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    public Hyperlink newUser;

    public TextField id;

    public TextField password;

    public Label errorMessage;

    public void newListener(ActionEvent actionEvent) throws IOException {
        Stage st=(Stage)newUser.getScene().getWindow();
        Parent root=FXMLLoader.load(getClass().getResource("signup.fxml"));
        st.setScene(new Scene(root));
    }

    public void onClick(ActionEvent actionEvent)
    {
        String userId = id.getText();
        String userPassword = password.getText();
        if(userId.equals("") || userPassword.equals("")){
            errorMessage.setText("No field should be empty!");
        }else{
            JdbcConnection obj = new JdbcConnection();
            String q = "select userId,password,name from users";
            try{
                PreparedStatement ptsmt = obj.getConection().prepareStatement(q);
                ResultSet set = ptsmt.executeQuery();
                boolean flag = true;
                while(set.next()){
                    if(set.getString(1).equals(userId) && set.getString(2).equals(userPassword)){
                        flag = false;
                        String name = set.getString(3);

                        //Redirecting to landingPage
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("landingPage.fxml"));
                        Parent root = loader.load();

                        LandingPage landingPage = loader.getController();
                        landingPage.setUserTitle(name);

                        Stage st=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        st.setScene(scene);
                        st.show();
                    }
                }

                if (flag)
                    errorMessage.setText("Wrong userId and Password!");

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
