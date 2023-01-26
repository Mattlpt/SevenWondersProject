package com.sevenwonders.view;

import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PlayerView implements Subscriber {
        
    private StackPane stackPane ;
    private BorderPane layout;
    private Scene playerView;

    public PlayerView(){

        this.layout = new BorderPane(); 

        this.playerView = new Scene(layout, 1200, 700); 
    }

    @Override
    public void update(Game game) {
        
    }

    public Scene getScene() {
        return this.playerView;
    }

}
