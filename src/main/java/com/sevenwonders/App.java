package com.sevenwonders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.sevenwonders.controller.LauncherViewController;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        GameMaster gameController = new GameMaster(new Game()); 
        LauncherViewController launcherView = new LauncherViewController();
        launcherView.setGameController(gameController);
        gameController.subscribe(launcherView);

        launcherView.show();

        gameController.notifySubscribers();
    }

    public static void main(String[] args) {
        launch();
    }

}