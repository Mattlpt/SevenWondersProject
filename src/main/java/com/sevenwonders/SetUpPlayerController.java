package com.sevenwonders;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetUpPlayerController extends Stage implements Subscriber {

    private GameMaster gameMaster;
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

    /*
     *  Déclare le controller 
     */
    public void setGameController(GameMaster gameMaster){this.gameMaster = gameMaster;}

    /*
     *  Update ; met à jour les donnée du jeu sur la vue 
     */
    @Override
    public void update(Game game) {
        this.game = game ;
        updateComponents(); 
    }

    /*
     *  Action du bouton 
     * 
     *  "getText()" -> reçoit la chaine de caractère entrée dans le text field
     *  Appel la fonction "receivePlayerNumber" dans Game Master
     *  Appel setScene (Afficher une scène) dans la classe Game Master [non fait]
     */
    @FXML
    protected void onButtonClickContinue(){
        gameMaster.receivePlayerNumber(theTextField.getText());
    }

    private void updateComponents() {
    }

}
