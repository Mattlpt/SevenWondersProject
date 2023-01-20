package com.sevenwonders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ControllerGame {
    private List<Subscriber> subscribers = new ArrayList<>();
    private Game game ; 
    private static Scene scene; 

    public ControllerGame(Game game){
        this.game = game ; 
        this.game.setGameController(this);  
    }

    /**
     * Adds a subscriber to the list
     * @param subscriber
     */
    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    /**
     * Remove subscriber from the list
     * @param subscriber
     */
    public void unsubscribe(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    /**
     * Loop through the subscriber list to update
     */
    public void notifySubscribers(){
        for (Subscriber subscriber: subscribers) {
            subscriber.update(game);
        }
    }

    /**
     * Afficher la page SetUpPlayer
     * @throws IOException
     */

    public static void setScene(Stage stage, Game game, ControllerGame gameController) throws IOException {
        ControllerSetUpPlayer setUpPlayer = new ControllerSetUpPlayer();
        setUpPlayer.setGameController(gameController);
        gameController.subscribe(setUpPlayer);

        setUpPlayer.show(); 
        gameController.notifySubscribers();
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void receivePlayerNumber(String nbPlayerText) {
        this.game.setPlayerNumber(nbPlayerText); 
    }
}
