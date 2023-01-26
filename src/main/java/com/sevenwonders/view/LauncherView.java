package com.sevenwonders.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;
import com.sevenwonders.controller.LauncherViewController;
import com.sevenwonders.controller.PlayerViewController;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class LauncherView extends Stage{

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

    LauncherViewController controller;
    private TextField setUpTextField; 

    public LauncherView() throws IOException{

        
         //Bouton
         this.startButton = new Button("Start");
         this.startButton.setTextFill(Color.WHITE);
         this.startButton.setFont(new Font("Arial", 28));
         this.startButton.setPrefHeight(100);
         this.startButton.setPrefWidth(200);
         this.startButton.setStyle("-fx-background-color: #ad2d2d; -fx-cursor: hand; -fx-lighting-color: white");
         this.shadow1 = new DropShadow(10, Color.BLACK);
         this.startButton.setEffect(shadow1);

         //Boite de Dialogue 
        this.setUpTextField = new TextField();
        this.setUpTextField.setMaxWidth(80);
        this.setUpTextField.setStyle("-fx-min-width: 100px; -fx-pref-width: 200px; -fx-max-width: 300px; -fx-control-inner-background: fff4d9; -fx-border-color: gray; -fx-border-width: 2;");

 
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
        
        this.controller = new LauncherViewController();

        // this.startButton.setOnAction(e -> {
        // });

        this.startButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                Game game = new Game();
                PlayerViewController playerViewController = new PlayerViewController(game); 

                PlayerView playerView = new PlayerView();

                playerView.setController(playerViewController);
                playerViewController.subscribe(playerView);

                PlayerView playerView2 = new PlayerView();
                playerView2.setController(playerViewController);
                playerViewController.subscribe(playerView2);

                playerView.show();
                playerView2.show();

                playerViewController.notifySubscribers();
            }
             
        });

 
         this.imageView.setFitHeight(1.0);
         this.imageView.setFitWidth(1.0);
         this.layout = new StackPane();
//         this.layout.setBackground(new Background(this.backgroundImage));  
         this.layout.getChildren().addAll(this.startButton, this.setUpTextField);
         this.launcherView = new Scene(this.layout, 1244, 700);

         this.setScene(launcherView);
    }

    /**
     * @param controller
     */
    public void setController(LauncherViewController controller){
        this.controller = controller; 
    }
    public LauncherViewController getController() {
        return controller;
    }
}
