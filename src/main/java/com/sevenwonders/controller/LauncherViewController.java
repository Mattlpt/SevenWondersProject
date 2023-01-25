package com.sevenwonders.controller;

import java.io.IOException;

import com.sevenwonders.App;
import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;
import com.sevenwonders.view.LauncherView;
import com.sevenwonders.view.PlayerSetUpView;

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

public class LauncherViewController implements Subscriber{

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

    /*
     *  Charge la page FXML
     */
    public LauncherViewController() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Launcher.fxml"));
        fxmlLoader.setControllerFactory(type -> this);
        mainScene = new Scene(fxmlLoader.load());
        

        // LauncherView launcherView = new LauncherView();
        // launcherView.show();
    }

    /*
     *  Déclare le controller 
     */
    public void setGameMaster(GameMaster gameMaster){this.gameMaster = gameMaster;}

    @Override
    public void update(Game game) {
        this.game = game ;
        updateComponents(); 
    }

    private void updateComponents() {}

    /*
     *  Action du bouton 
     *  Appel setSceneSetUpPlayer (Afficher une scène) dans la classe Game Master
     */



}
