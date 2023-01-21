package com.sevenwonders.controller;

import java.io.IOException;

import com.sevenwonders.App;
import com.sevenwonders.Game;
import com.sevenwonders.GameMaster;
import com.sevenwonders.Subscriber;
import com.sevenwonders.view.PlayerSetUpView;
import com.sevenwonders.view.WonderSetUpView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetUpPlayerController extends Stage implements Subscriber {

    private GameMaster gameController;
    private Game game; 
    private Scene setUpPlayerScene;
    
    private App app;

    @FXML
    Label theLabel;
    @FXML
    TextField theTextField;
    @FXML
    Button theButton;

    public SetUpPlayerController() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SetUpPlayer.fxml"));
        fxmlLoader.setControllerFactory(type -> this);
        setUpPlayerScene = new Scene(fxmlLoader.load());
        this.setTitle("Launcher");
        this.setScene(setUpPlayerScene);


    }

    public void setGameController(GameMaster gameController){this.gameController = gameController;}

    @Override
    public void update(Game game) {
        this.game = game ;
        updateComponents(); 
    }

    @FXML
    protected void onButtonClickContinue(){
        gameController.receivePlayerNumber(theTextField.getText());
        /*
         * Affiche la page "wonderSetUp" qui est une vue JavaFX
         */
        WonderSetUpView wonderSetUpView = new WonderSetUpView();
        wonderSetUpView.show();

    }

    private void updateComponents() {
    }

}
