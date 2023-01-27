package com.sevenwonders.Card;

import java.io.File;

import javafx.scene.image.Image;

public class YellowCard extends Card {
    public YellowCard() {
        this.color = "Yellow";
        this.image = new Image(new File("src/main/Ressources/Card/YellowCard.png").toURI().toString());
    }
}
