package com.sevenwonders.Card;

import javafx.scene.image.Image;

public class Card {
    protected String color;
    protected Image image;

    public Card() {}

    public String toString() {
        return "class : " + this.getClass() + " color : " + this.color;
    }

    public String getColor() {
        return this.color;
    }

    public Image getImage() {
        return this.image;
    }
}