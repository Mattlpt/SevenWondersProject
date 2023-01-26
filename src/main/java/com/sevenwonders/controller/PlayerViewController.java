package com.sevenwonders.controller;

import com.sevenwonders.GameMaster;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class PlayerViewController {
    private GameMaster gameMaster;
    private EventHandler<ActionEvent> eventHandler;

    public PlayerViewController(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                
            }
            
        };
    }

    public EventHandler<ActionEvent> getHandler() {
        return this.eventHandler;
    }

    public GameMaster getMaster() {
        return this.gameMaster;
    }
}
