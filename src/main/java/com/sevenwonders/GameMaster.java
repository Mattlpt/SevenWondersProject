package com.sevenwonders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sevenwonders.controller.SetUpPlayerController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GameMaster {

    /*
     *  Game Master ; le coeur du jeu. 
     *  c'est ici qu'on lieu les implémentations 
     */

    private List<Subscriber> subscribers = new ArrayList<>();
    private Game game ; 
    private static Scene scene; 

    public GameMaster(Game game){
        this.game = game ;
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


     /*
      *  setSceneSetUpPlayer ; 
      */

    public void receivePlayerNumber(String nbPlayerText) {
        this.game.setPlayerNumber(nbPlayerText); 
    }
}
