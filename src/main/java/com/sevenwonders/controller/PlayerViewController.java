package com.sevenwonders.controller;

import java.util.ArrayList;

import com.sevenwonders.GameMaster;
import com.sevenwonders.Player;

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
                Player player = getMaster().getGame().playerView.getPlayer();
                int playerId = getMaster().fetchPlayerId(player);
                ArrayList<Player> playerList = getMaster().getGame().getPlayerList();
                Player lastPlayer = playerList.get((playerId+(playerList.size()-1))%playerList.size());
                if(eventButton.getText() == "Pioche Principale") {
                    getMaster().draw(player, getMaster().getGame().getMainDraw());
                }
                if(eventButton.getText() == "Pioche Gauche") {
                    getMaster().draw(player, player.getWonder().getDeckOfCards());
                }
                if(eventButton.getText() == "Pioche Droite") {
                    getMaster().draw(player, lastPlayer.getWonder().getDeckOfCards());
                }
                gameMaster.notifySubscribers();
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