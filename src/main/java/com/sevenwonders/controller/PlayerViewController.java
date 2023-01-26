package com.sevenwonders.controller;

import java.util.ArrayList;
import java.util.List;

import com.sevenwonders.Game;
import com.sevenwonders.Subscriber;

public class PlayerViewController {
    private List<Subscriber> subscribers = new ArrayList<>();
    private Game game;

    public PlayerViewController(Game game) {
        this.game = game;
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
}
