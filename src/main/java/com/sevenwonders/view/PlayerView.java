package com.sevenwonders.view;


import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class PlayerView implements Subscriber {
    
    private Scene playerView;
    private BorderPane layout; ;

    private EventHandler<ActionEvent> controller;

    public PlayerView(EventHandler<ActionEvent> eventHandler) {
        this.controller = eventHandler;

        layout = new BorderPane();

        //VBox de fond 
        VBox vBoxFond = new VBox();

        //HBox en bas, pour les trois boutons
        HBox hBoxBas = new HBox();
        hBoxBas.setAlignment(Pos.CENTER);
        
        //HBox en haut, pour des pions et tt
        HBox hBoxHaut = new HBox();

        //HBox au milieu, pour dec et pioches
        HBox hBoxMilieu = new HBox(); 

        //VBox Dec 
        VBox vBoxDeck = new VBox(); 

        //Boutons 

        Button centreButton = new Button();
        Button leftButton = new Button(); 
        Button rightButton = new Button(); 

        hBoxBas.getChildren().addAll(leftButton, centreButton, rightButton); 

        layout.setBottom(hBoxBas);


        playerView = new Scene(layout,1200,700);
        
    }

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public Scene getScene() {
        return this.playerView;
    }

}
