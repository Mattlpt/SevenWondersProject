package com.sevenwonders.Card;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;

public class DeckOfCards {
    private ArrayList<Card> content;
    private boolean face_Up;
    private Image image;

    public DeckOfCards(int size, boolean face_Up) {
        this.content = new ArrayList<Card>();
        this.face_Up = face_Up;
        for(int i=0; i<size; i++) {
            if(i < size/2) {
                this.content.add(new GreyCard(new Resource("Bois")));
            }
            if(i >= size/2) {
                this.content.add(new YellowCard());
            }
        }
        Collections.shuffle(this.content);
    }

    public void setImage(String string) {
        if(this.face_Up == true) {
            this.image = this.content.get(0).getImage();
        }
        if(this.face_Up == false) {
            this.image = new Image((new File("src/main/Ressources/Card/back/Back+"+string+"Card.png")).toURI().toString());
        }
    }

    public String toString() {
        return this.content.toString();
    }
    

    public ArrayList<Card> getContent() {
        return this.content;
    }
    public Image getImage() {
        return this.image;
    }
}