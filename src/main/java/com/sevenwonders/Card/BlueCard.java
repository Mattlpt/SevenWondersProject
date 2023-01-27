package com.sevenwonders.Card;

import javafx.scene.image.Image;

import java.io.File;

import javafx.scene.image.Image;

public class BlueCard extends Card {
    private int victoryPoint;

    public BlueCard(int nb) {
        this.color = "Blue";
        this.image = new Image(new File("src/main/Ressources/Card/BlueCard.png").toURI().toString());
        this.victoryPoint = nb;
    }

    public int getVictoryPoint() {
        return this.victoryPoint;
    }
}
