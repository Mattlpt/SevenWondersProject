package com.sevenwonders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.Flow.Publisher;

import com.sevenwonders.controller.LauncherViewController;
import com.sevenwonders.controller.PlayerViewController;
import com.sevenwonders.view.LauncherView;
import com.sevenwonders.view.PlayerSetUpView;
import com.sevenwonders.view.PlayerView;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Game game = new Game();
        // PlayerViewController playerViewController = new PlayerViewController(game); 

        // PlayerView playerView = new PlayerView();

        // playerView.setController(playerViewController);
        // playerViewController.subscribe(playerView);

        // PlayerView playerView2 = new PlayerView();
        // playerView2.setController(playerViewController);
        // playerViewController.subscribe(playerView2);

        // playerView.show();
        // playerView2.show();

        LauncherViewController launcherViewController = new LauncherViewController();
        LauncherView launcherView = new LauncherView();
        launcherView.setController(launcherViewController);

        launcherView.show(); 
        // playerViewController.notifySubscribers();
    }

    public static void main(String[] args) {
        launch();
    }

}