package com.sevenwonders.view;


import java.io.File;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
        hBoxBas.setSpacing(30);
        hBoxBas.setPadding(new Insets(0,0,20,0)); 

        //HBox en haut, pour des pions et tt
        HBox hBoxHaut = new HBox();
        hBoxHaut.setAlignment(Pos.CENTER);
        hBoxHaut.setPadding(new Insets(20,0,0,0)); 

        //HBox au milieu, pour dec et pioches
        HBox hBoxMilieu = new HBox(); 
        hBoxMilieu.setAlignment(Pos.CENTER);

        //VBox Dec 
        VBox vBoxDeck = new VBox(); 
        vBoxDeck.setAlignment(Pos.CENTER);

        Image leftDrawn = new Image(new File("src/main/Ressources/ressouces 7W 2/cardsTest.png").toURI().toString());
        ImageView leftDrawView = new ImageView(leftDrawn);

        //DOCK
        Image imageDeck = new Image(new File("src/main/Ressources/wonder_alexandriaTEST.png").toURI().toString());
        ImageView imageViewDeck = new ImageView(imageDeck);

        //Drown
        Image rightDrawn = new Image(new File("src/main/Ressources/ressouces 7W 2/cardsTest.png").toURI().toString());
        ImageView rightDrawView = new ImageView(rightDrawn);



        //Boutons Centre
        Button centreButton = new Button("Button");
        centreButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");
        
        //Bouton Gauche
        Button leftButton = new Button("Button"); 
        leftButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");
       
        //Bouton Droit
        Button rightButton = new Button("Button"); 
        rightButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");
        
        //Bouton Haut 
        Button infoButton = new Button("Button"); 
        infoButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");


        hBoxHaut.getChildren().add(infoButton); 

        hBoxMilieu.getChildren().addAll(leftDrawView, vBoxDeck, rightDrawView);
        vBoxDeck.getChildren().add(imageViewDeck); 

        
        hBoxBas.getChildren().addAll(leftButton, centreButton, rightButton); 

        layout.setCenter(hBoxMilieu);
        layout.setBottom(hBoxBas);
        layout.setTop(hBoxHaut);


        playerView = new Scene(layout,1200,800);
        
    }

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public Scene getScene() {
        return this.playerView;
    }

}
