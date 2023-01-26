package com.sevenwonders.controller;

import java.io.IOException;

import com.sevenwonders.App;
import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;
import com.sevenwonders.view.LauncherView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.control.ListCell;

public class LauncherViewController {

    /*
     *  LauncherViewController ; Controller de la vue Launcher
     */

    private GameMaster gameMaster;
    private Scene mainScene;
    
    private App app;

    @FXML
    Label theLabel;
    @FXML
    TextField theTextField;
    @FXML
    Button theButton;

    private Game game;

    
    public LauncherViewController(){

        

    }



}
