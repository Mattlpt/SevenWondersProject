package com.sevenwonders.controller;


import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PlayerViewController {
    
    GameMaster gameMaster;
    EventHandler eventHandler;

    public PlayerViewController(GameMaster gameMaster){

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
