package com.sevenwonders.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Player;
import com.sevenwonders.wonder.Wonder;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WonderSetUpController {

    private GameMaster gameMaster;
    EventHandler eventHandler;

    public WonderSetUpController(GameMaster gameMaster){
        this.gameMaster = gameMaster;
        this.eventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button eventButton = (Button) event.getSource();
                Scene scene = eventButton.getScene();
                Stage window = (Stage) scene.getWindow();
                ArrayList<Player> playerList = getMaster().getGame().getPlayerList();
                ArrayList<Wonder> wonderList = getMaster().getGame().getWonderList();
                int counter = 1;
                for(int i=0; i<playerList.size(); i++) {
                    if(playerList.get(i).getWonder() == null) {
                        VBox box = null;
                        Label label;
                        for(int j=0; j<scene.getRoot().getChildrenUnmodifiable().size(); j++) {
                            if(scene.getRoot().getChildrenUnmodifiable().get(j).getId() == "mainBox") {
                                HBox hbox = (HBox) scene.getRoot().getChildrenUnmodifiable().get(j);
                                for(int k=0; k<hbox.getChildren().size(); k++) {
                                    if(hbox.getChildren().get(k).getId() == "wonderChoice") {
                                        box = (VBox) hbox.getChildren().get(k);
                                    }
                                }
                            }
                            if(scene.getRoot().getChildrenUnmodifiable().get(j).getId() == "titleBox") {
                                HBox hbox2 = (HBox) scene.getRoot().getChildrenUnmodifiable().get(j);
                                try {
                                    ((Label)hbox2.getChildren().get(0)).setText(playerList.get(i+1).getName()+" Choisissez votre merveille");
                                }catch(IndexOutOfBoundsException e) {}
                            }

                        }
                        playerList.get(i).setWonder(GameMaster.fetchWonder(wonderList, ((Button)box.getChildren().get(1)).getText()));
                        box.getChildren().remove(box.getChildren().get(1));
                        break;
                    }
                    counter += 1;
                }
                if(counter == playerList.size()) {
                    getMaster().getGame().playerView.setPlayer(getMaster().getGame().getPlayerList().get(0));
                    gameMaster.notifySubscribers();
                    window.setScene(getMaster().getGame().playerView.getScene());
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