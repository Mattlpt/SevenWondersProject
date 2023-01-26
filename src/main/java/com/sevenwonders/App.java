package com.sevenwonders;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Game game = new Game();
        GameMaster gameMaster = new GameMaster(game);
        gameMaster.subscribe(game.launcherView);
        gameMaster.subscribe(game.launcherViewController);

        Stage window = stage;
        window.setTitle("7 Wonders : Architects");
        window.setScene(game.launcherView.getScene());
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

}