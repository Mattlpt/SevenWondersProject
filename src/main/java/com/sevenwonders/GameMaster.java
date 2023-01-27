package com.sevenwonders;

import javafx.event.EventHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.sevenwonders.Card.BlueCard;
import com.sevenwonders.Card.Card;
import com.sevenwonders.Card.DeckOfCards;
import com.sevenwonders.Card.GreyCard;
import com.sevenwonders.Card.RedCard;
import com.sevenwonders.Card.Resource;
import com.sevenwonders.Card.YellowCard;
import com.sevenwonders.wonder.Wonder;
import com.sevenwonders.wonder.Alexendrie;
import com.sevenwonders.wonder.Babylon;
import com.sevenwonders.wonder.Ephese;
import com.sevenwonders.wonder.Gizeh;
import com.sevenwonders.wonder.Halicarnasse;
import com.sevenwonders.wonder.Olympie;
import com.sevenwonders.wonder.Part;
import com.sevenwonders.wonder.Rhodes;


import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GameMaster {

    private List<Subscriber> subscribers;
    private Game game ;

    public GameMaster(){
        this.subscribers = new ArrayList<Subscriber>();
    }

    public void draw(Player player, DeckOfCards deck) {
        if(deck.getContent().size() > 0) {
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
            if(pick instanceof YellowCard) {
                YellowCard card = (YellowCard) pick;
                player.setPiece(player.getPiece() + 1);
                
            }
            if(pick instanceof BlueCard) {
                BlueCard card = (BlueCard) pick;
                player.setPoint(player.getPoint()+card.getVictoryPoint());
            }
            if(pick instanceof RedCard) {
                RedCard card = (RedCard) pick;
                player.setBouclier(player.getBouclier()+card.getBouclier());
            }
            deck.getContent().remove(pick);
        }
        resourceCount(player);
    }

    public void resourceCount(Player player) {
        Boolean bool = fetchPart(player.getWonder()).getSame();
        HashMap<String, Integer> resourceList = player.getResourceList();
        if(bool == false) {
            resourceList.forEach((key, value) -> {
                if(value > 0) {
                    player.setCount(player.getCount()+1);
                }
            });
        }
        if(bool == true) {
            resourceList.forEach((key, value) -> {
                if(value > player.getCount()) {
                    player.setCount(value);
                } 
            });
        }
        player.setCount(player.getCount()+player.getPiece());
        checkBuild(player);
    }

    public void checkBuild(Player player) {
        Part part = fetchPart(player.getWonder());
        int nb = part.getCount();
        if(player.getCount() >= nb) {
            part.setIsBuilt(true);
            System.out.println("built !!!!!!!!!!!!!");
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

    public void buildWonder(Player player, VBox vBox) {
        for(int i=player.getWonder().getParts().length-1; i>=0; i--) {
            vBox.getChildren().add(new ImageView(player.getWonder().getParts()[i].getImage()));
        }
    }

    public void setPlayers(int nb) {
        ArrayList<Player> playerList = this.game.getPlayerList();
        for(int i=0; i<nb; i++) {
            playerList.add(new Player("Joueur"+(i+1)));
        }
        Collections.shuffle(playerList);
    }

    public Player fetchPlayer(int nb) {
        ArrayList<Player> playerList = this.game.getPlayerList();
        int index = nb%playerList.size();
        Player player = playerList.get(index);
        return player;
    }

    public int fetchPlayerId(Player player) {
        int nb = 0;
        for(int i=0; i<this.game.getPlayerList().size(); i++) {
            if(player == this.game.getPlayerList().get(i)) {
                nb = i;
            }
        }
        return nb;
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

    public static Part fetchPart(Wonder wonder) {
        Part part = null;
        Part[] parts = wonder.getParts();
        for(int i=0; i<parts.length; i++) {
            if(parts[i].getIsBuilt() == false) {
                part = parts[i];
                break;
            }
        }
        return part;
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
                    Scene scene = eventButton.getScene();
                    Stage window = (Stage) scene.getWindow();
                    BorderPane layout = (BorderPane) eventButton.getParent().getParent().getParent();
                    layout.setBackground(new Background(new BackgroundImage(new Image(new File("src/main/Ressources/BackgroundWonders/Background"+eventButton.getText()+".png").toURI().toString()), null, null, null, null)));
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