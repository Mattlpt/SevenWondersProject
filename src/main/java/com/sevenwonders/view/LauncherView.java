package com.sevenwonders.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;



public class LauncherView implements Subscriber{

    public Scene launcherView;
    public StackPane layout;
    public Button startButton;
    public DropShadow shadow1 ;
    public Timeline timeline = new Timeline();
    public KeyFrame kF ;
    public KeyFrame kF2;
    final Image image = new Image(new File("src/main/Ressources/ressouces 7W 2/7wonders-cover-2.jpg").toURI().toString());
    public final ImageView imageView = new ImageView(image); 
    BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);
    public Timeline timelineMouseExit;

    EventHandler<ActionEvent> controller; 
    
    public LauncherView(EventHandler<ActionEvent> eventHandler) {
        this.controller = eventHandler;

        // Fond
        final Image image = new Image(new File("src/main/Ressources/ressouces 7W 2/7wonders-cover-2.jpg").toURI().toString());
        final ImageView imageView = new ImageView(image); 
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);

         //Bouton
         this.startButton = new Button("Start");
         this.startButton.setTextFill(Color.WHITE);
         this.startButton.setFont(new Font("Arial", 28));
         this.startButton.setPrefHeight(100);
         this.startButton.setPrefWidth(200);
         this.startButton.setStyle("-fx-background-color: #ad2d2d; -fx-cursor: hand; -fx-lighting-color: white");
         this.shadow1 = new DropShadow(10, Color.BLACK);
         this.startButton.setEffect(shadow1);
         this.kF = new KeyFrame(
             Duration.millis(80), 
             new KeyValue(this.startButton.prefWidthProperty(), 215),
             new KeyValue(this.startButton.prefHeightProperty(), 115)
             );
         this.timeline.getKeyFrames().add(this.kF);
         this.startButton.setOnMouseEntered(event -> {this.timeline.play();});
 
         this.timelineMouseExit = new Timeline();
         this.kF2 = new KeyFrame(
             Duration.millis(100), 
             new KeyValue(this.startButton.prefHeightProperty(), 100), 
             new KeyValue(this.startButton.prefWidthProperty(), 200)
         ); 
         this.timelineMouseExit.getKeyFrames().add(this.kF2);
         this.startButton.setOnMouseExited(event -> {this.timelineMouseExit.play();});

         this.startButton.setOnAction(this.controller);


         this.layout = new StackPane();
         this.layout.setBackground(new Background(this.backgroundImage));
         this.layout.getChildren().add(this.startButton);
         this.launcherView = new Scene(this.layout, 1200, 700);

    }

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public Scene getScene() {
        return this.launcherView;
    }
}
