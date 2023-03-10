package com.sevenwonders.Card;

import java.io.File;

import javafx.scene.image.Image;

public class GreyCard extends Card {
    private Resource resource;

    public GreyCard(Resource resource) {
        this.color = "Grey";
        this.resource = resource;
        this.image = new Image(new File("src/main/Ressources/Card/GreyCard.png").toURI().toString());
    }

    @Override
    public String toString() {
        return this.getClass() + " de couleur : " + this.getColor() + " resource : " + this.resource;
    }

    // Affichage de la carte 
    //final Image image = new Image(new File("src/main/resources/images/cards/card-material-" + resource.getName() + ".png").toURI().toString());
    //final ImageView imageView = new ImageView(image);

    // Get et Set
    public Resource getResource() {
        return this.resource;
    }

    public String getColor() {
        return this.color;
    }
}