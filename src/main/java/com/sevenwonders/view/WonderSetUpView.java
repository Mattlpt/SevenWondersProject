package com.sevenwonders.view;

import java.io.File;
import java.util.ArrayList;

import com.sevenwonders.Player;
import com.sevenwonders.controller.WonderSetUpController;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WonderSetUpView extends Stage{

    ArrayList<Player> players;
    
    Scene wonderSetUp;
    BorderPane layout;
    HBox mainBox;
    VBox wonderList;
    VBox wonderChoice;
    HBox titleBox;
    HBox confirmBox;
    Label title;
    Label wonderListLabel;
    Label wonderChoiceLabel;
    Button confirmButton;
    final Image image = new Image(new File("src/main/resources/images/Scene/7wonders-SetWonder2 copie.jpg").toURI().toString());
    final ImageView imageView = new ImageView(image); 
    BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);
    FadeTransition fadeTransition;

    public WonderSetUpView() {
        this.setScene(wonderSetUp);
        
        this.confirmButton = new Button("Confirmer");
        this.confirmButton.setEffect(new Glow(0.3));
        this.confirmButton.setEffect(new DropShadow(30, Color.BLACK));
        this.confirmButton.setStyle("-fx-min-width: 180px; -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #65749d; -fx-text-fill: white; ");
        this.fadeTransition = new FadeTransition(Duration.millis(200), this.confirmButton); 
        this.fadeTransition.setFromValue(0.5);
        this.fadeTransition.setToValue(1.0);


        this.confirmButton.setOnAction(e -> {

        });
        this.confirmBox = new HBox();
        this.confirmBox.setAlignment(Pos.CENTER);
        this.confirmBox.setPadding(new Insets(0,0,30,0)); 
        this.confirmBox.setSpacing(40);
        this.confirmBox.getChildren().add(this.confirmButton);


        this.title = new Label("Choisissez votre merveille");
        this.titleBox = new HBox();
        this.titleBox.setId("titleBox");
        this.titleBox.setAlignment(Pos.CENTER);
        this.titleBox.setPadding(new Insets(30,0,0,0));
        this.titleBox.getChildren().add(this.title);
        this.titleBox.setSpacing(40);


        this.wonderChoiceLabel = new Label("Votre choix :");
        this.wonderChoice = new VBox();
        this.wonderChoice.setId("wonderChoice");
        this.wonderChoice.setAlignment(Pos.CENTER);
        this.wonderChoice.setPadding(new Insets(0,80,0,0));
        this.wonderChoice.setSpacing(30);
        this.wonderChoice.getChildren().add(this.wonderChoiceLabel);

        this.wonderListLabel = new Label("Choisissez parmis :");
        this.wonderList = new VBox();
        this.wonderList.setId("wonderList");
        this.wonderList.setAlignment(Pos.CENTER);
        this.wonderList.setPadding(new Insets(0,0,0,80));
        this.wonderList.setSpacing(20);
        this.wonderList.getChildren().add(this.wonderListLabel);

        this.mainBox = new HBox();
        this.mainBox.setId("mainBox");
        this.mainBox.setAlignment(Pos.CENTER);
        this.mainBox.getChildren().addAll(this.wonderChoice, this.wonderList);
        this.mainBox.setSpacing(40);

        this.layout = new BorderPane();
        this.layout.setTop(this.titleBox);
        this.layout.setBottom(this.confirmBox);
        this.layout.setCenter(this.mainBox);
        this.layout.setBackground(new Background(this.backgroundImage));  
        this.wonderSetUp = new Scene(this.layout, 1244, 700);
    }

    public void setUpScene() {
    //      ArrayList<Wonder> wonders = this.getWonders();
    //     // this.title.setText(Model.getPlayers().get(0).getName()+" Choisssez votre merveille");
    //     // for(int i=0; i<wonders.size(); i++) {

    //         // Bouton de choix des merveilles 

    //         Button button = new Button(wonders.get(i).getName());
    //         button.setBackground(new Background(new BackgroundFill(wonders.get(i).getColor(), CornerRadii.EMPTY, Insets.EMPTY)));
    //         button.setEffect(new Glow(0.3));
    //         button.setEffect(new DropShadow(10, Color.BLACK));
    //         button.setStyle("-fx-min-width: 180px -fx-pref-width: 180px; -fx-max-width: 180px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-text-fill: white; ");
    //         this.fadeTransition = new FadeTransition(Duration.millis(200), button); 
    //         this.fadeTransition.setFromValue(0.5);
    //         this.fadeTransition.setToValue(1.0);
    //         button.setOnAction(new EventHandler<ActionEvent>() {

    //             @Override
    //             public void handle(ActionEvent event) {
    //                 Button eventButton = (Button) event.getSource();
    //                 HBox box = (HBox) eventButton.getParent().getParent();
    //                 VBox box1 = null;
    //                 VBox box2 = null;
    //                 for(int i=0; i<box.getChildren().size(); i++) {
    //                     if(box.getChildren().get(i).getId() == "wonderList") {
    //                         box1 = (VBox) box.getChildren().get(i);
    //                     }
    //                     if(box.getChildren().get(i).getId() == "wonderChoice") {
    //                         box2 = (VBox) box.getChildren().get(i);
    //                     }
    //                 }
    //                 if(eventButton.getParent() == box1 && box2.getChildren().size() < 2) {
    //                     box1.getChildren().remove(eventButton);
    //                     box2.getChildren().add(eventButton);
    //                     box2 = null;
    //                 }
    //                 if(eventButton.getParent() == box2) {
    //                     box2.getChildren().remove(eventButton);
    //                     box1.getChildren().add(eventButton);
    //                 }
    //             }
                
    //         });
    //         this.wonderList.getChildren().add(button);
    //     }
    //     this.wonderList.getChildren().addAll();
    }
    
}
