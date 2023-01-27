package com.sevenwonders;

import javafx.event.EventHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.sevenwonders.Card.Card;
import com.sevenwonders.Card.DeckOfCards;
import com.sevenwonders.Card.GreyCard;
import com.sevenwonders.Card.Resource;
import com.sevenwonders.wonder.*;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class GameMaster {

    private List<Subscriber> subscribers;
    private Game game ;

    public GameMaster(){
        this.subscribers = new ArrayList<Subscriber>();
    }

    public void draw(Player player, DeckOfCards deck) {
        Card pick = deck.getContent().get(0);
        if(pick instanceof GreyCard) {
            GreyCard card = (GreyCard) pick;
            Resource resource = card.getResource();
            HashMap<String, Integer> resourceList = player.getResourceList();
            resourceList.forEach((key, value) -> {
                if(key == resource.getName()) {
                    resourceList.replace(key, value, value+1);
                }
            });
        }
    }

    public void setWonders() {
        ArrayList<Wonder> wonderList = this.game.getWonderList();
        wonderList.add(new Alexendrie());
        wonderList.add(new Babylon());
        wonderList.add(new Ephese());
        wonderList.add(new Gizeh());
        wonderList.add(new Halicarnasse());
        wonderList.add(new Olympie());
        wonderList.add(new Rhodes());
        
    }

    public void setPlayers(int nb) {
        ArrayList<Player> playerList = this.game.getPlayerList();
        for(int i=0; i<nb; i++) {
            playerList.add(new Player("Joueur"+(i+1)));
        }
        Collections.shuffle(playerList);
    }

    public static Wonder fetchWonder(ArrayList<Wonder> list, String name) {
        Wonder wonder = null;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).getName() == name) {
                wonder = list.get(i);
                break;
            }
        }
        return wonder;
    }

    public void WonderSetUpViewSetUp() {
        ArrayList<Wonder> wonderList = this.game.getWonderList();
        ArrayList<Player> playerList = this.game.getPlayerList();
        Label title = (Label) fetchChildren(this.game.wonderSetUpView.getLayout(), "title");
        VBox wonderListBox = (VBox) fetchChildren(this.game.wonderSetUpView.getLayout(), "wonderList");
        title.setText(playerList.get(0).getName()+" Choisssez votre merveille");
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    Button eventButton = (Button) event.getSource();
                    HBox box = (HBox) eventButton.getParent().getParent();
                    VBox box1 = null;
                    VBox box2 = null;
                    for(int i=0; i<box.getChildren().size(); i++) {
                        if(box.getChildren().get(i).getId() == "wonderList") {
                            box1 = (VBox) box.getChildren().get(i);
                        }
                        if(box.getChildren().get(i).getId() == "wonderChoice") {
                            box2 = (VBox) box.getChildren().get(i);
                        }
                    }
                    if(eventButton.getParent() == box1 && box2.getChildren().size() < 2) {
                        box1.getChildren().remove(eventButton);
                        box2.getChildren().add(eventButton);
                        box2 = null;
                    }
                    if(eventButton.getParent() == box2) {
                        box2.getChildren().remove(eventButton);
                        box1.getChildren().add(eventButton);
                    }
                }
        };
        for(int i=0; i<wonderList.size(); i++) {
            Button button = new Button(wonderList.get(i).getName());
            button.setStyle("-fx-min-width: 160px; -fx-pref-width: 160px; -fx-max-width: 160px; -fx-min-height : 40px; -fx-pref-height : 40px; -fx-max-height : 40px; -fx-cursor : hand; -fx-background-color: #dccaae; -fx-text-fill: white;");
            button.setOnAction(eventHandler);
            wonderListBox.getChildren().add(button);
        }
    }

    public Node fetchChildren(Parent parent, String id) {
        ObservableList<Node> list = parent.getChildrenUnmodifiable();
        Node node = null;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) instanceof VBox) {
                VBox vBox = (VBox) list.get(i);
                for(int j=0; j<vBox.getChildren().size(); j++) {
                    if(vBox.getChildren().get(j).getId() == id) {
                        node = vBox.getChildren().get(j);
                    }
                }
            }
            if(list.get(i) instanceof HBox) {
                HBox hBox = (HBox) list.get(i);
                for(int j=0; j<hBox.getChildren().size(); j++) {
                    if(hBox.getChildren().get(j).getId() == id) {
                        node = hBox.getChildren().get(j);
                    }
                }
            }
            if(list.get(i).getId() == id) {
                node = list.get(i);
            }
        }
        return node;
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
