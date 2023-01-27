package com.sevenwonders.wonder;

import com.sevenwonders.Card.DeckOfCards;

import javafx.scene.paint.Color;

public class Gizeh extends Wonder{
    public Gizeh() {
        this.name = "Gizeh";
        this.color = Color.web("a35f38"); 
        this.parts = new Part[5];
        this.deck = new DeckOfCards(30, true);
        setParts();
    }

    @Override
    public void setParts() {
        for(int i=0; i<this.parts.length; i++) {
            switch(i) {
                case 0 :
                    this.parts[i] = new Part("part"+(i+1), false, 2, 4, null);
                    break;
                case 1 :
                    this.parts[i] = new Part("part"+(i+1), true, 2, 5, null);
                    break;
                case 2 :
                    this.parts[i] = new Part("part"+(i+1), false, 3, 6, null);
                    break;
                case 3 :
                    this.parts[i] = new Part("part"+(i+1), true, 3, 7, null);
                    break;
                case 4 :
                    this.parts[i] = new Part("part"+(i+1), false, 4, 8, null);
                    break;
            }
        }
    }
}
