package com.example.mynotes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LandingPage
{

    @FXML
    public Label userTitle;
    public String userId;
    public ResultSet set;

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
            TextField contentArea=new TextField();
            //contentArea.applyCs
            list.getSelectionModel().selectedItemProperty().addListener(String selectedItem=list.getSelectionModel().getSelectedItems();
            contentArea.setText(lk);



           /* ObservableList<String> title = FXCollections.observableArrayList();
            while (set.next()){
                title.add(set.getString(5));
            }
            System.out.println(title);
            list = new ListView<String>(title);*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

