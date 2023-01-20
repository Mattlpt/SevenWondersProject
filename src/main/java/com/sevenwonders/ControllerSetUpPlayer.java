package com.sevenwonders;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerSetUpPlayer extends Stage implements Subscriber {

    private ControllerGame gameController;
    private Game game; 
    private Scene setUpPlayerScene;
    
    private App app;

    @FXML
    Label theLabel;
    @FXML
    TextField theTextField;
    @FXML
    Button theButton;

    public ControllerSetUpPlayer() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SetUpPlayer.fxml"));
        fxmlLoader.setControllerFactory(type -> this);
        setUpPlayerScene = new Scene(fxmlLoader.load());
        this.setTitle("Launcher");
        this.setScene(setUpPlayerScene);
    }

    public void setGameController(ControllerGame gameController){this.gameController = gameController;}

    @Override
    public void update(Game game) {
        this.game = game ;
        updateComponents(); 
    }

    @FXML
    protected void onButtonClick(){
        gameController.receivePlayerNumber(theTextField.getText());
    }

    private void updateComponents() {
    }

}
