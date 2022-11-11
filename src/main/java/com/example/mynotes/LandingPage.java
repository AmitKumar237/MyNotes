package com.example.mynotes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class LandingPage
{

    @FXML
    public Label userTitle;


    void setUserTitle(String name){
        userTitle.setText(name);
    }
}

