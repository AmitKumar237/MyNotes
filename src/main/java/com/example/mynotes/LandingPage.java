package com.example.mynotes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Filter;

public class LandingPage
{

    @FXML
    public Label userTitle;
    public String userId;
    public TextArea showContent;


    @FXML
    public ListView<String> list;

    public Label updateMsg;

    void setUserTitle(String name , String userId){
        userTitle.setText(name);
        this.userId = userId;
    }

    public void setList(){
        String q = "select * from tasks "+" where id = ?";
        try {
            PreparedStatement ptsmt = JdbcConnection.con.prepareStatement(q);
            ptsmt.setString(1,userId);
            ResultSet set = ptsmt.executeQuery();
            while (set.next())
            {
              list.getItems().add(set.getString(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showContentOfTitle(MouseEvent mouseEvent) {
        updateMsg.setText("");
        String title = list.getSelectionModel().getSelectedItem();
        System.out.println(title);
        String q = "select content from tasks "+"where id=? and title=?";
        try{
            PreparedStatement ptsmt = JdbcConnection.con.prepareStatement(q);
            ptsmt.setString(1,userId);
            ptsmt.setString(2,title);
            ResultSet set = ptsmt.executeQuery();
            while (set.next())
                showContent.setText(set.getString(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void goToNewTask(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("createTask.fxml"));
            Parent root = loader.load();
            Stage st=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            st.setScene(scene);
            st.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateTask(ActionEvent actionEvent) {
        String content = showContent.getText();
        String q = "update tasks set content = ?"+"where id=?";
        try{
            PreparedStatement ptsmt = JdbcConnection.con.prepareStatement(q);
            ptsmt.setString(1,content);
            ptsmt.setString(2,userId);
            ptsmt.executeUpdate();
            updateMsg.setText("Updated Successfully!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

