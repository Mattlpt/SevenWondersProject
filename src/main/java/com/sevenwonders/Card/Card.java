package com.sevenwonders.Card;

import javafx.scene.image.ImageView;

public class Card {
    protected String color;
    protected ImageView imageView;

    public Card() {}

    public String toString() {
        return "class : " + this.getClass() + " color : " + this.color;
    }

    public String getColor() {
        return this.color;
    }

    public ImageView getImageView() {
        return this.imageView;
    }
}