package com.sevenwonders.view;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Player;
import com.sevenwonders.Subscriber;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
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
    VBox inventoryBox;
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
    Label pieceLabel;
    Label bouclierLabel;
    Label vPLabel;
    Image leftDrawn;
    Image imageDeck;
    Image rightDrawn;
    Image mainDraw;
    ImageView leftDrawView;
    ImageView imageViewDeck;
    ImageView rightDrawView;
    ImageView mainDrawView;



    private EventHandler<ActionEvent> controller;

    private Image bouclierImage;

    private ImageView bouclierImageView;

    private ImageView boisImageView;

    private Image boisImage;

    private HBox rescourceBoisBox;

    private Image pierreImage;

    private ImageView pierreImageView;

    private HBox rescourcePierreBox;

    private HBox rescourcePapierBox;

    private Image papierImage;

    private ImageView papierImageView;

    private Image verreImage;

    private ImageView verreImageView;

    private HBox rescourceVerreBox;

    private HBox inventoryVPBox;

    private HBox inventorypieceBox;

    private Image pieceImage;

    private ImageView pieceImageView;

    private Image vPImage;

    private ImageView vPImageView;

    private HBox inventoryBouclierBox;

    private Image emptyDraw;

    private ImageView emptyDrawView;

    final String imageURI3 = new File("src/main/Ressources/BackgroundWonders/WhatsApp Image 2023-01-27 at 15.32.55.jpeg").toURI().toString(); 
    final Image image3 = new Image(imageURI3);
    final ImageView imageView2 = new ImageView(image3); 
    BackgroundImage backgroundImage2 = new BackgroundImage(image3, null, null, null, null);

    public PlayerView(EventHandler<ActionEvent> eventHandler) {
        this.controller = eventHandler;

        



        //Boutons Centre
        this.centreButton = new Button("Pioche Principale");
        this.centreButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");
        this.centreButton.setOnAction(this.controller);
        //Bouton Gauche
        this.leftButton = new Button("Pioche Gauche"); 
        this.leftButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");      
        this.leftButton.setOnAction(this.controller);
        //Bouton Droit
        this.rightButton = new Button("Pioche Droite"); 
        this.rightButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");    
        this.rightButton.setOnAction(this.controller);

        //Bouton Haut 
        this.infoButton = new Button("Change Player"); 
        this.infoButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white;");

        //BOIS
        this.boisLabel = new Label(" x ");
        this.boisLabel.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-text-fill: #7f522a;");
        this.boisImage = new Image(new File("src/main/Ressources/icones/BOIS.png").toURI().toString());
        this.boisImageView = new ImageView(this.boisImage); 

        this.pierreLabel = new Label(" x ");
        this.pierreLabel.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-text-fill: #7f522a;");
        this.pierreImage = new Image(new File("src/main/Ressources/icones/pierre.png").toURI().toString());
        this.pierreImageView = new ImageView(this.pierreImage); 

        this.papierLabel = new Label(" x ");
        this.papierLabel.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-text-fill: #7f522a;");
        this.papierImage = new Image(new File("src/main/Ressources/icones/papier.png").toURI().toString());
        this.papierImageView = new ImageView(this.papierImage); 

        this.verreLabel = new Label(" x ");
        this.verreLabel.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-text-fill: #7f522a;");
        this.verreImage = new Image(new File("src/main/Ressources/icones/Verre.png").toURI().toString());
        this.verreImageView = new ImageView(this.verreImage); 

        this.pieceLabel = new Label(" x ");
        this.pieceLabel.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-text-fill: #7f522a;");
        this.pieceImage = new Image(new File("src/main/Ressources/icones/or.png").toURI().toString());
        this.pieceImageView = new ImageView(this.pieceImage); 

        this.bouclierLabel = new Label(" x ");
        this.bouclierLabel.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-text-fill: #7f522a;");
        this.bouclierImage = new Image(new File("src/main/Ressources/icones/Bouclier.png").toURI().toString());
        this.bouclierImageView = new ImageView(this.bouclierImage); 

        this.vPLabel = new Label("Points : ");
        this.vPLabel.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-text-fill: #7f522a;");
        this.vPImage = new Image(new File("src/main/Ressources/icones/Lauriers.png").toURI().toString());
        this.vPImageView = new ImageView(this.vPImage); 


        this.leftDrawn = new Image(new File("src/main/Ressources/Card/BlueCard.png").toURI().toString());
        this.leftDrawView = new ImageView(this.leftDrawn);

        //Drown
        this.rightDrawn = new Image(new File("src/main/Ressources/Card/BlueCard.png").toURI().toString());
        this.rightDrawView = new ImageView(this.rightDrawn);

        this.mainDraw = new Image(new File("src/main/Ressources/Card/BlueCard.png").toURI().toString());
        this.mainDrawView = new ImageView(this.mainDraw);

        this.emptyDraw = new Image(new File("src/main/Ressources/Card/62.png").toURI().toString());
        this.emptyDrawView = new ImageView(this.emptyDraw);

        //DOCK
        this.imageDeck = new Image(new File("src/main/Ressources/wonder_alexandriaTEST.png").toURI().toString());
        this.imageViewDeck = new ImageView(this.imageDeck);  

        //HBox en bas, pour les trois boutons

        VBox mainDrawBox = new VBox();
        mainDrawBox.setAlignment(Pos.TOP_LEFT);
        mainDrawBox.getChildren().add(this.mainDrawView);

        VBox emptyDrawBox = new VBox(); 
        emptyDrawBox.setAlignment(Pos.TOP_RIGHT);
        emptyDrawBox.getChildren().add(this.emptyDrawView);

        this.hBoxBottom = new HBox();
        this.hBoxBottom.setAlignment(Pos.CENTER);
        this.hBoxBottom.setSpacing(30);
        this.hBoxBottom.setPadding(new Insets(0,0,20,0));
        this.hBoxBottom.getChildren().addAll(this.leftButton, this.centreButton, this.rightButton);

        this.resourceBox = new VBox();
            this.rescourceBoisBox = new HBox(); 
            this.rescourceBoisBox.getChildren().addAll(this.boisImageView, this.boisLabel); 

            this.rescourcePierreBox = new HBox();
            this.rescourcePierreBox.getChildren().addAll(this.pierreImageView, this.pierreLabel);

            this.rescourcePapierBox = new HBox(); 
            this.rescourcePapierBox.getChildren().addAll(this.papierImageView, this.papierLabel);

            this.rescourceVerreBox = new HBox();
            this.rescourceVerreBox.getChildren().addAll(this.verreImageView, this.verreLabel);

        this.resourceBox.setAlignment(Pos.CENTER);
        this.resourceBox.setSpacing(30);
        this.resourceBox.setPadding(new Insets(20,0,0,0)); 
        this.resourceBox.getChildren().addAll(this.rescourceBoisBox, this.rescourcePierreBox, this.rescourcePapierBox, this.rescourceVerreBox);

        this.inventoryBox = new VBox();
            this.inventoryVPBox = new HBox();
            this.inventoryVPBox.getChildren().addAll(this.vPLabel, this.vPImageView);
            
            this.inventoryBouclierBox = new HBox();
            this.inventoryBouclierBox.getChildren().addAll(this.bouclierLabel, this.bouclierImageView);

            this.inventorypieceBox = new HBox();
            this.inventorypieceBox.getChildren().addAll(this.pieceLabel, this.pieceImageView);

        this.inventoryBox.setAlignment(Pos.CENTER);
        this.inventoryBox.setSpacing(30);
        this.inventoryBox.getChildren().addAll(this.inventoryVPBox, this.inventoryBouclierBox, this.inventorypieceBox);

        //HBox en haut, pour des pions et tt
        this.hBoxTop = new HBox();
        this.hBoxTop.setAlignment(Pos.CENTER);
        this.hBoxTop.setPadding(new Insets(20,0,0,0));
        this.hBoxTop.getChildren().add(this.infoButton);

        //VBox Dec 
        this.wonderBox = new VBox(); 
        this.wonderBox.setId("wonderBox");
        this.wonderBox.setAlignment(Pos.CENTER);
        
         

        this.hBoxHaut = new HBox();
        this.hBoxHaut.setAlignment(Pos.CENTER);


        //HBox au milieu, pour dec et pioches
        this.hBoxBas = new HBox(); 
        this.hBoxBas.setAlignment(Pos.CENTER);
        this.hBoxBas.getChildren().addAll(mainDrawBox, this.leftDrawView, this.wonderBox, this.rightDrawView, emptyDrawBox);

        this.vBoxMilieu = new VBox();
        this.vBoxMilieu.setAlignment(Pos.CENTER);
        this.vBoxMilieu.getChildren().addAll(this.hBoxHaut, this.hBoxBas);

        this.layout = new BorderPane();
        this.layout.setCenter(this.vBoxMilieu);
        this.layout.setBottom(this.hBoxBottom);
        this.layout.setTop(this.hBoxTop);
        this.layout.setLeft(this.resourceBox);
        this.layout.setRight(this.inventoryBox);

        // this.layout.setBackground(new Background(this.backgroundImage2));

        this.playerView = new Scene(this.layout,1200,800);
        
    }

    @Override
    public void update(Game game) {
        ArrayList<Player> playerList = game.getPlayerList();
        int playerId = game.getMaster().fetchPlayerId(this.player);
        Player lastPlayer = game.getPlayerList().get((playerId+(playerList.size()-1))%playerList.size());
        this.boisLabel.setText(" x "+this.player.getResourceList().get("Bois"));
        this.pierreLabel.setText(" x "+this.player.getResourceList().get("Pierre"));
        this.papierLabel.setText(" x "+this.player.getResourceList().get("Papier"));
        this.verreLabel.setText(" x "+this.player.getResourceList().get("Verre"));
        this.pieceLabel.setText(this.player.getPiece() + " x ");
        this.vPLabel.setText(this.player.getPoint()+ " x ");
        this.bouclierLabel.setText(this.player.getBouclier()+ " x ");
        
        if(this.player.getWonder().getDeckOfCards().getContent().size() > 0) {
            this.player.getWonder().getDeckOfCards().setImage(this.player.getWonder().getName());
            this.leftDrawView.setImage(this.player.getWonder().getDeckOfCards().getImage());
        }
        if(this.player.getWonder().getDeckOfCards().getContent().size() == 0) {
            this.leftDrawView.setImage(null);
        }
        if(lastPlayer.getWonder().getDeckOfCards().getContent().size() > 0) {
            lastPlayer.getWonder().getDeckOfCards().setImage(this.player.getWonder().getName());
            this.rightDrawView.setImage(lastPlayer.getWonder().getDeckOfCards().getImage());
        }
        if(lastPlayer.getWonder().getDeckOfCards().getContent().size() == 0) {
            this.rightDrawView.setImage(null);
        }
        if(game.getMainDraw().getContent().size() > 0) {
            game.getMainDraw().setImage("Gizeh");
            this.mainDrawView.setImage(game.getMainDraw().getImage());
        }
        if(game.getMainDraw().getContent().size() == 0) {
            this.mainDrawView.setImage(null);
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

    public BorderPane getLayout() {
        return this.layout;
    }

}