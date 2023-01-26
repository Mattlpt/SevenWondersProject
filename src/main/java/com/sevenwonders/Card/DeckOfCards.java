package com.sevenwonders.Card;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    private ArrayList<Card> content;
    private boolean face_Up;

    public DeckOfCards(int size, boolean face_Up) {
        this.content = new ArrayList<Card>();
        this.face_Up = face_Up;
        for(int i=0; i<size; i++) {
            this.content.add(new GreyCard(new Resource("Bois")));
        }
        Collections.shuffle(this.content);
    }
    

    public ArrayList<Card> getContent() {
        return this.content;
    }
}
