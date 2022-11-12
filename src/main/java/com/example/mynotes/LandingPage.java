package com.example.mynotes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LandingPage
{

    @FXML
    public Label userTitle;
    public String userId;
    public TextArea showContent;


    @FXML
    public ListView<String> list;

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
}

