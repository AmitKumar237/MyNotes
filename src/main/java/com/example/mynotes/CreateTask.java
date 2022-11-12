package com.example.mynotes;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
import java.time.LocalDate;

public class CreateTask
{
    public TextField tasksField;
    public DatePicker reminderSet;
    public Button toSave;
    public TextField title;
    public Date i;
    public String userId;

    public Label errorMessage;
    void setUserId(String tmp){
        userId = tmp;
    }

    public void onClickRemider(ActionEvent actionEvent)
    {
        i= Date.valueOf(reminderSet.getValue());
    }

    public void onClick(ActionEvent actionEvent)
    {
        if(title.getText().equals("")){
            errorMessage.setText("Title is mandatory!");
        }else {
            String q = "Insert into tasks(id,remainderTime,title,content)values(?,?,?,?)";

            try {
                PreparedStatement ptsmt = JdbcConnection.con.prepareStatement(q);
                System.out.println("Done...");
                ptsmt.setString(1, userId);
                ptsmt.setDate(2, i);
                ptsmt.setString(3, title.getText());
                ptsmt.setString(4, tasksField.getText());
                ptsmt.executeUpdate();
                System.out.println("Done...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
