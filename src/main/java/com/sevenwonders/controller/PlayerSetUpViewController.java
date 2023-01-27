package com.sevenwonders.controller;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PlayerSetUpViewController{

    private GameMaster gameMaster;
    EventHandler<ActionEvent> eventHandler;

    public PlayerSetUpViewController(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.eventHandler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Button eventButton = (Button) event.getSource();
                Scene scene = eventButton.getScene();
                Stage window = (Stage) scene.getWindow();
                TextField textField = null;
                int nb = 0;
                for(int i=0; i<eventButton.getParent().getChildrenUnmodifiable().size(); i++) {
                    if(eventButton.getParent().getChildrenUnmodifiable().get(i) instanceof TextField) {
                        textField = (TextField) eventButton.getParent().getChildrenUnmodifiable().get(i);
                    }
                }
                try {
                    nb = Integer.parseInt(textField.getText());
                }catch(NumberFormatException e) {textField.setText(null);}
                if(nb > 1 && nb < 8) {
                    getMaster().setPlayers(nb);
                    getMaster().setWonders();
                    getMaster().WonderSetUpViewSetUp();
                    window.setScene(getMaster().getGame().wonderSetUpView.getScene());
                }
                else {
                    textField.setText(null);
                }
                
            }  
        };
    }


    // @Override
    // public void update(Game game) {
    //     // TODO Auto-generated method stub
        
    // }

    public EventHandler<ActionEvent> getHandler() {
        return this.eventHandler;
    }

    public GameMaster getMaster() {
        return this.gameMaster;
    }

}
