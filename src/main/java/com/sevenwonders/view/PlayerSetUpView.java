package com.sevenwonders.view;

import java.io.File;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;

import javafx.animation.FadeTransition;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlayerSetUpView implements Subscriber{

    public Scene playerSetUp;
    BorderPane layout;
    HBox titleBox;
    VBox setUpBox;
    Label title;
    Label setUpLabel;
    TextField setUpTextField;
    Button setUpButton;
    final String imageURI2 = new File("src/main/resources/images/Scene/7-wonders-ChosePlayerPage.jpg").toURI().toString(); 
    final Image image2 = new Image(imageURI2);
    final ImageView imageView2 = new ImageView(image2); 
    BackgroundImage backgroundImage2 = new BackgroundImage(image2, null, null, null, null);
    FadeTransition fadeTransition;

    final Image image = new Image(new File("").toURI().toString());
    final ImageView imageView = new ImageView(image); 
    BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);

    private EventHandler<ActionEvent> controller; 
    
    public PlayerSetUpView() {

        //Titre 
        this.title = new Label("Selection des joueurs");
        this.title.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold; -fx-text-fill: white;");
        this.title.setEffect(new DropShadow(1, Color.BLACK));
        this.titleBox = new HBox();
        this.titleBox.getChildren().add(this.title);
        this.titleBox.setPadding(new Insets(10, 0, 0, 0));
        this.titleBox.setAlignment(Pos.CENTER);

        //Instruction
        this.setUpLabel = new Label("Entrez le nombre de joueurs");
        this.setUpLabel.setTextFill(Color.WHITE);
        this.setUpLabel.setFont(new Font(38));
        this.setUpLabel.setEffect(new DropShadow(20, Color.BLACK));

        //Boite de Dialogue 
        this.setUpTextField = new TextField();
        this.setUpTextField.setMaxWidth(80);
        this.setUpTextField.setStyle("-fx-min-width: 100px; -fx-pref-width: 200px; -fx-max-width: 300px; -fx-control-inner-background: fff4d9; -fx-border-color: gray; -fx-border-width: 2;");

        //Bouton
        this.setUpButton = new Button("Confirmer");
        this.setUpButton.setEffect(new Glow(0.3));
        this.setUpButton.setEffect(new DropShadow(30, Color.BLACK));
        this.setUpButton.setStyle("-fx-min-width: 180px -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white; ");
        this.fadeTransition = new FadeTransition(Duration.millis(200), this.setUpButton); 
        this.fadeTransition.setFromValue(0.5);
        this.fadeTransition.setToValue(6.0);

        this.setUpButton.setOnAction(e -> {

        });

        this.setUpBox = new VBox();
        this.setUpBox.getChildren().addAll(this.setUpLabel, this.setUpTextField, this.setUpButton);
        this.setUpBox.setAlignment(Pos.CENTER);
        this.setUpBox.setSpacing(60);

        this.layout = new BorderPane();
        this.layout.setTop(this.titleBox);
        this.layout.setCenter(this.setUpBox);
        this.layout.setBackground(new Background(this.backgroundImage2));
        this.playerSetUp = new Scene(this.layout, 1244, 700);

        
    }

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public void setController(EventHandler<ActionEvent> eventHandler) {
        this.controller = eventHandler;
    }
}
