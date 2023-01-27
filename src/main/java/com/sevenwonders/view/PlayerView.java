package com.sevenwonders.view;


import java.io.File;
import java.util.ArrayList;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Player;
import com.sevenwonders.Subscriber;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    VBox resourceBox;
    VBox vBoxMilieu;
    HBox hBoxHaut;
    HBox hBoxBas;
    VBox wonderBox;

    Button centreButton;
    Button leftButton;
    Button rightButton;
    Button infoButton;
    Label boisLabel;
    Label pierreLabel;
    Label papierLabel;
    Label verreLabel;
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

        this.boisLabel = new Label("Bois : ");
        this.pierreLabel = new Label("Pierre : ");
        this.papierLabel = new Label("Papier");
        this.verreLabel = new Label("Verre");

        this.leftDrawn = new Image(new File("src/main/Ressources/Card/BlueCard.png").toURI().toString());
        this.leftDrawView = new ImageView(this.leftDrawn);

        //Drown
        this.rightDrawn = new Image(new File("src/main/Ressources/Card/BlueCard.png").toURI().toString());
        this.rightDrawView = new ImageView(this.rightDrawn);

        //DOCK
        this.imageDeck = new Image(new File("src/main/Ressources/wonder_alexandriaTEST.png").toURI().toString());
        this.imageViewDeck = new ImageView(this.imageDeck);  

        //HBox en bas, pour les trois boutons
        this.hBoxBottom = new HBox();
        this.hBoxBottom.setAlignment(Pos.CENTER);
        this.hBoxBottom.setSpacing(30);
        this.hBoxBottom.setPadding(new Insets(0,0,20,0));
        this.hBoxBottom.getChildren().addAll(this.leftButton, this.centreButton, this.rightButton);

        this.resourceBox = new VBox();
        this.resourceBox.setAlignment(Pos.CENTER);
        this.resourceBox.setSpacing(30);
        this.resourceBox.getChildren().addAll(this.boisLabel, this.pierreLabel);

        //HBox en haut, pour des pions et tt
        this.hBoxTop = new HBox();
        this.hBoxTop.setAlignment(Pos.CENTER);
        this.hBoxTop.setPadding(new Insets(20,0,0,0));
        this.hBoxTop.getChildren().add(this.infoButton);

        //VBox Dec 
        this.wonderBox = new VBox(); 
        this.wonderBox.setAlignment(Pos.CENTER);
        this.wonderBox.getChildren().add(this.imageViewDeck); 

        this.hBoxHaut = new HBox();
        this.hBoxHaut.setAlignment(Pos.CENTER);
        
        //HBox au milieu, pour dec et pioches
        this.hBoxBas = new HBox(); 
        this.hBoxBas.setAlignment(Pos.CENTER);
        this.hBoxBas.getChildren().addAll(this.leftDrawView, this.wonderBox, this.rightDrawView);

        this.vBoxMilieu = new VBox();
        this.vBoxMilieu.setAlignment(Pos.CENTER);
        this.vBoxMilieu.getChildren().addAll(this.hBoxHaut, this.hBoxBas);

        this.layout = new BorderPane();
        this.layout.setCenter(this.vBoxMilieu);
        this.layout.setBottom(this.hBoxBottom);
        this.layout.setTop(this.hBoxTop);
        this.layout.setLeft(this.resourceBox);


        this.playerView = new Scene(this.layout,1200,800);
        
    }

    @Override
    public void update(Game game) {
        ArrayList<Player> playerList = game.getPlayerList();
        int playerId = game.getMaster().fetchPlayerId(this.player);
        Player lastPlayer = game.getPlayerList().get((playerId+(playerList.size()-1))%playerList.size());
        this.boisLabel.setText("Bois : "+this.player.getResourceList().get("Bois"));
        this.pierreLabel.setText("Pierre : "+this.player.getResourceList().get("Pierre"));
        this.papierLabel.setText("Papier : "+this.player.getResourceList().get("Papier"));
        this.verreLabel.setText("Verre : "+this.player.getResourceList().get("Verre"));
        if(this.player.getWonder().getDeckOfCards().getContent().size() > 0) {
            this.leftDrawView.setImage(new Image(new File("src/main/Ressources/Card/"+this.player.getWonder().getDeckOfCards().getContent().get(0).getColor()+"Card.png").toURI().toString()));
        }
        if(this.player.getWonder().getDeckOfCards().getContent().size() == 0) {
            this.leftDrawView.setImage(null);
        }
        if(lastPlayer.getWonder().getDeckOfCards().getContent().size() > 0) {
            this.rightDrawView.setImage(new Image(new File("src/main/Ressources/Card/"+lastPlayer.getWonder().getDeckOfCards().getContent().get(0).getColor()+"Card.png").toURI().toString()));
        }
        if(lastPlayer.getWonder().getDeckOfCards().getContent().size() == 0) {
            this.rightDrawView.setImage(null);
        }

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