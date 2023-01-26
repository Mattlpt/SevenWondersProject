package com.sevenwonders.view;

import com.sevenwonders.Game;
import com.sevenwonders.Subscriber;
import com.sevenwonders.controller.PlayerViewController;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayerView extends Stage implements Subscriber{

    private Game game ;
    private PlayerViewController controller;

    private Scene mainScene;
    private StackPane rootStackPane = new StackPane() ;
    private Label gameName = new Label();

    public PlayerView(){
        this.rootStackPane.getChildren().add(gameName);
        this.mainScene = new Scene(rootStackPane, 600, 500);
        this.setScene(mainScene);
    }

    @Override
    public void update(Game game) {
        this.game = game ; 
        updateView(); 
    }

    private void updateView() {
        this.gameName.setText(game.toString());
    } 
    
    public PlayerViewController getController() {
        return controller;
    }

    public void setController(PlayerViewController controller) {
        this.controller = controller;
    }
}
