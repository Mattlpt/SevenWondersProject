package com.sevenwonders.controller;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SetUpPlayerController implements Subscriber {

    private GameMaster gameMaster;
    EventHandler<ActionEvent> eventHandler;

    public SetUpPlayerController() {
        this.eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Button eventButton = (Button) event.getSource();
                Scene scene = eventButton.getScene();
                
            }  
        };
    }

    

    @FXML
    protected void onButtonClickContinue(){

    }

    private void updateComponents() {
    }



    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public EventHandler<ActionEvent> getHandler() {
        return this.eventHandler;
    }



    @Override
    public GameMaster getMaster() {
        // TODO Auto-generated method stub
        return null;
    }

}
