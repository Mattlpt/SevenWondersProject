package com.sevenwonders.controller;

import com.sevenwonders.GameMaster;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class PlayerViewController {
    private GameMaster gameMaster;
    private EventHandler<ActionEvent> eventHandler;

    public PlayerViewController(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Button eventButton = (Button) event.getSource();
                Scene scene = eventButton.getScene();
                Stage window = (Stage) scene.getWindow();
                if(eventButton.getText() == "Pioche Principale") {
                    getMaster().draw(getMaster().getGame().playerView.getPlayer(), getMaster().getGame().getMainDraw());
                }
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