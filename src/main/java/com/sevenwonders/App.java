package com.sevenwonders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.sevenwonders.controller.LauncherViewController;
import com.sevenwonders.view.LauncherView;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        GameMaster gameMaster = new GameMaster(new Game()); //Initialise le game master et son argulement le model "game"

        LauncherViewController launcherView = new LauncherViewController();
        launcherView.setGameMaster(gameMaster);

        // LauncherView launcherView = new LauncherView(); 
        // launcherView.setGameMaster(gameMaster);

        gameMaster.subscribe(launcherView);

        launcherView.show();

        gameMaster.notifySubscribers();
    }

    public static void main(String[] args) {
        launch();
    }

}