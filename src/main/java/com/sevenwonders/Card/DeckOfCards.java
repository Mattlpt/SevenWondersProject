package com.sevenwonders.Card;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.ImageView;

public class DeckOfCards {
    private ArrayList<Card> content;
    private boolean face_Up;
    private ImageView imageView;

    public DeckOfCards(int size, boolean face_Up) {
        this.content = new ArrayList<Card>();
        this.face_Up = face_Up;
        for(int i=0; i<size; i++) {
            this.content.add(new GreyCard(new Resource("Bois")));
        }
        Collections.shuffle(this.content);
    }

    public void setView() {
        if(this.face_Up == true) {
            this.imageView = this.content.get(0).getImageView();
        }
        if(this.face_Up == false) {
            this.imageView =null;
        }
    }

    public String toString() {
        return this.content.toString();
    }
    

    public ArrayList<Card> getContent() {
        return this.content;
    }
}
