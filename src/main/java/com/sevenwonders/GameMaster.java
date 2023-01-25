package com.sevenwonders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GameMaster {

    private List<Subscriber> subscribers;
    private Game game ;

    public GameMaster(Game game){
        this.game = game ;
        this.subscribers = new ArrayList<Subscriber>();
        this.game.launcherView.setController(this.game.launcherViewController.getHandler());
        this.game.playerSetUpView.setController(this.game.setUpPlayerController.getHandler());
        this.game.wonderSetUpView.setController(this.game.wonderSetUpController.getHandler());
        this.game.launcherViewController.setGameMaster(this);
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

    public Game getGame() {
        return this.game;
    }
}
