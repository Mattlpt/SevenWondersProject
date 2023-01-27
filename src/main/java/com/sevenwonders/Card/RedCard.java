package com.sevenwonders.Card;

import java.io.File;

import javafx.scene.image.Image;

public class RedCard extends Card {
    private int bouclier;

    public RedCard(int nb) {
        this.color = "Red";
        this.bouclier = nb;
        this.image = new Image(new File("src/main/Ressources/Card/RedCard.png").toURI().toString());
    }

    public int getBouclier() {
        return this.bouclier;
    }
}