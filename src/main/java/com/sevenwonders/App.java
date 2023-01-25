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

    @Override
    public void start(Stage stage) throws IOException {
        GameMaster gameMaster = new GameMaster(new Game());
        LauncherView launcherView = new LauncherView();
        
        gameMaster.subscribe(launcherView);
        gameMaster.notifySubscribers();

        Stage window = stage;
        window.setTitle("7 Wonders : Architects");
        window.setScene(launcherView.getScene());
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

}