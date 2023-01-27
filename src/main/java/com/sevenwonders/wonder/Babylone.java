package com.sevenwonders.wonder;

import com.sevenwonders.Card.DeckOfCards;

import javafx.scene.paint.Color;

public class Babylone extends Wonder{
    public Babylone() {
        this.name = "Babylone";
        this.color = Color.web("336a51"); ; 
        this.parts = new Part[5];
        this.deck = new DeckOfCards(30, true);
        setParts();
    }

    @Override
    public void setParts() {
        for(int i=0; i<this.parts.length; i++) {
            switch(i) {
                case 0 :
                    this.parts[i] = new Part("part"+(i+1), false, 2, 3, null);
                    break;
                case 1 :
                    this.parts[i] = new Part("part"+(i+1), true, 2, 0, null);
                    break;
                case 2 :
                    this.parts[i] = new Part("part"+(i+1), false, 3, 5, null);
                    break;
                case 3 :
                    this.parts[i] = new Part("part"+(i+1), true, 3, 5, null);
                    break;
                case 4 :
                    this.parts[i] = new Part("part"+(i+1), false, 4, 7, null);
                    break;
            }
        }
    }
}
