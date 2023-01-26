package com.sevenwonders.Card;

public class Card {
    protected String color;

    public Card() {}

    public String toString() {
        return "class : " + this.getClass() + " color : " + this.color;
    }

    public String getColor() {
        return this.color;
    }
}
