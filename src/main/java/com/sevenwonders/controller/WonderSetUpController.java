package com.sevenwonders.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;

import javafx.scene.Scene;
import javafx.scene.control.Button;

public class WonderSetUpController {

    private GameMaster gameMaster;
    EventHandler eventHandler;

    public WonderSetUpController(){
        this.eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Button eventButton = (Button) event.getSource();
                Scene scene = eventButton.getScene();
                
            }
            
        };
    }

    public EventHandler<ActionEvent> getHandler() {
        return this.eventHandler;
    }
    
}
