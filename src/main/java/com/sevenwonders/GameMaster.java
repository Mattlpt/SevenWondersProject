package com.sevenwonders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameMaster {

    private List<Subscriber> subscribers;
    private Game game ;

    public GameMaster(){
        this.subscribers = new ArrayList<Subscriber>();
    }

    public void setPlayers(int nb) {
        ArrayList<Player> playerList = this.game.getPlayerList();
        for(int i=0; i<nb; i++) {
            playerList.add(new Player("Joueur"+(i+1)));
        }
        Collections.shuffle(playerList);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
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

    
}
