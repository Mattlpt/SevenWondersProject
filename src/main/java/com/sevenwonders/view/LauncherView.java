package com.sevenwonders.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    final Image image = new Image(new File("src/main/resources/images/Scene/7wonders-" + "StartPage.jpg").toURI().toString());
    public final ImageView imageView = new ImageView(image); 
    BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);
    public Timeline timelineMouseExit;

    EventHandler<ActionEvent> controller; 
    
    public LauncherView(EventHandler<ActionEvent> eventHandler) {
        this.controller = eventHandler;

         //Bouton
         this.startButton = new Button("Start");
         this.startButton.setOnAction(this.controller);
         this.layout = new StackPane();
         this.layout.getChildren().add(this.startButton);
         this.launcherView = new Scene(this.layout, 800, 500);

    }

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public Scene getScene() {
        return this.launcherView;
    }
}
