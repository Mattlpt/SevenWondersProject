package com.sevenwonders.wonder;

import com.sevenwonders.Card.DeckOfCards;

import javafx.scene.paint.Color;

public abstract class Wonder {
    protected String name;
    protected Color color; 
    protected Part[] parts;
    protected DeckOfCards deck;

    public Wonder() {}
    
    public Wonder(String name, int count) {
        this.name = name;
        this.parts = new Part[count];
        this.deck = new DeckOfCards(30, true);
    }

    public void setParts() {}

    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return this.color;
    }

    public Part[] getParts() {
        return this.parts;
    }

    public DeckOfCards getDeckOfCards() {
        return this.deck;
    }

    public String toString() {
        return this.name;
    }
}
