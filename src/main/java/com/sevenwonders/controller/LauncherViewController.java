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


public class LauncherViewController implements Subscriber{

    GameMaster gameMaster;
    EventHandler eventHandler;
    
    public LauncherViewController(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                System.out.println("test");
                Button eventButton = (Button) event.getSource();
                Scene scene = eventButton.getScene();
                Stage window = (Stage) scene.getWindow();
                window.setScene(gameMaster.getGame().launcherView.getScene());
            }          
        };
    }
    
    public void setGameMaster(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
    }

    @Override
    public void update(Game game) {

    }

    public EventHandler<ActionEvent> getHandler() {
        return this.eventHandler;
    }

}
