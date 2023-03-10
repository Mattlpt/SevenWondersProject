package com.sevenwonders.controller;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class LauncherViewController{

    GameMaster gameMaster;
    EventHandler eventHandler;
    
    public LauncherViewController(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button eventButton = (Button) event.getSource();
                Scene scene = eventButton.getScene();
                Stage window = (Stage) scene.getWindow();
                window.setScene(getMaster().getGame().playerSetUpView.getScene());
            }          
        };
    }
    
    public void setGameMaster(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
    }


    public EventHandler<ActionEvent> getHandler() {
        return this.eventHandler;
    }

    public GameMaster getMaster() {
        return this.gameMaster;
    }

}
