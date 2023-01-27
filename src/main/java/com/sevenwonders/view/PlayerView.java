package com.sevenwonders.view;


import java.io.File;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Player;
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
    private Player player;

    Scene playerView;
    BorderPane layout;
    HBox hBoxBottom;
    HBox hBoxTop;
    VBox vBoxMilieu;
    HBox hBoxBas;
    VBox wonderBox;

    Button centreButton;
    Button leftButton;
    Button rightButton;
    Button infoButton;

    Image leftDrawn;
    Image imageDeck;
    Image rightDrawn;
    ImageView leftDrawView;
    ImageView imageViewDeck;
    ImageView rightDrawView;



    private EventHandler<ActionEvent> controller;

    public PlayerView(EventHandler<ActionEvent> eventHandler) {
        this.controller = eventHandler;

        //Boutons Centre
        this.centreButton = new Button("Pioche Principale");
        this.centreButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");
        this.centreButton.setOnAction(this.controller);
        //Bouton Gauche
        this.leftButton = new Button("Button"); 
        this.leftButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");      
        //Bouton Droit
        this.rightButton = new Button("Button"); 
        this.rightButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");    
        
        //Bouton Haut 
        this.infoButton = new Button("Button"); 
        this.infoButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");

        this.leftDrawn = new Image(new File("src/main/Ressources/ressouces 7W 2/cardsTest.png").toURI().toString());
        this.leftDrawView = new ImageView(this.leftDrawn);

        //DOCK
        this.imageDeck = new Image(new File("src/main/Ressources/wonder_alexandriaTEST.png").toURI().toString());
        this.imageViewDeck = new ImageView(this.imageDeck);

        //Drown
        this.rightDrawn = new Image(new File("src/main/Ressources/ressouces 7W 2/cardsTest.png").toURI().toString());
        this.rightDrawView = new ImageView(this.rightDrawn);


        //HBox en bas, pour les trois boutons
        this.hBoxBottom = new HBox();
        this.hBoxBottom.setAlignment(Pos.CENTER);
        this.hBoxBottom.setSpacing(30);
        this.hBoxBottom.setPadding(new Insets(0,0,20,0));
        this.hBoxBottom.getChildren().addAll(this.leftButton, this.centreButton, this.rightButton);

        //HBox en haut, pour des pions et tt
        this.hBoxTop = new HBox();
        this.hBoxTop.setAlignment(Pos.CENTER);
        this.hBoxTop.setPadding(new Insets(20,0,0,0));
        this.hBoxTop.getChildren().add(this.infoButton);

        //VBox Dec 
        this.wonderBox = new VBox(); 
        this.wonderBox.setAlignment(Pos.CENTER);
        this.wonderBox.getChildren().add(this.imageViewDeck); 

        //HBox au milieu, pour dec et pioches
        this.hBoxBas = new HBox(); 
        this.hBoxBas.setAlignment(Pos.CENTER);
        this.hBoxBas.getChildren().addAll(this.leftDrawView, this.wonderBox, this.rightDrawView);

        this.vBoxMilieu = new VBox();
        this.vBoxMilieu.setAlignment(Pos.CENTER);
        this.vBoxMilieu.getChildren().add(this.hBoxBas);

        this.layout = new BorderPane();
        this.layout.setCenter(this.vBoxMilieu);
        this.layout.setBottom(this.hBoxBottom);
        this.layout.setTop(this.hBoxTop);


        this.playerView = new Scene(this.layout,1200,800);
        
    }

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Scene getScene() {
        return this.playerView;
    }

}
