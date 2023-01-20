package com.sevenwonders;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.scene.control.ListCell;

public class ControllerLauncherView extends Stage implements Subscriber{

    private ControllerGame gameController;
    private Scene mainScene;
    
    private App app;

    @FXML
    Label theLabel;
    @FXML
    TextField theTextField;
    @FXML
    Button theButton;

    private Game game;

    public ControllerLauncherView() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Launcher.fxml"));
        fxmlLoader.setControllerFactory(type -> this);
        mainScene = new Scene(fxmlLoader.load());
        this.setTitle("Launcher");
        this.setScene(mainScene);
    }

    public void setGameController(ControllerGame gameController){this.gameController = gameController;}

    @Override
    public void update(Game game) {
        this.game = game ;
        updateComponents(); 
    }

    private void updateComponents() {}

    public void onButtonClick() throws IOException{
        this.gameController.setScene(null, game, gameController);
        this.close();
    }



}
