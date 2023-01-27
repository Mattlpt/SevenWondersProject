package com.sevenwonders.wonder;

import java.io.File;

import com.sevenwonders.Card.DeckOfCards;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Alexendrie extends Wonder{
    
    public Alexendrie() {
        this.name = "Alexandrie"; 
        this.color = Color.web("2a4f85"); ; 
        this.parts = new Part[5];
        this.deck = new DeckOfCards(30, true);
        setParts();

    }

    @Override
    public void setParts() {
        for(int i=0; i<this.parts.length; i++) {
            switch(i) {
                case 0 :
                    this.parts[i] = new Part(this.name+"Part"+(i+1), false, 2, 4, null);
                    this.parts[i].setImage(new Image(new File("src/main/Ressources/Wonders/"+this.name+"/Part_Constructions/wonder"+this.parts[i].getName()+".png").toURI().toString()));
                    break;
                case 1 :
                    this.parts[i] = new Part(this.name+"Part"+(i+1), true, 2, 3, null);
                    this.parts[i].setImage(new Image(new File("src/main/Ressources/Wonders/"+this.name+"/Part_Constructions/wonder"+this.parts[i].getName()+".png").toURI().toString()));
                    break;
                case 2 :
                    this.parts[i] = new Part(this.name+"Part"+(i+1), false, 3, 6, null);
                    this.parts[i].setImage(new Image(new File("src/main/Ressources/Wonders/"+this.name+"/Part_Constructions/wonder"+this.parts[i].getName()+".png").toURI().toString()));
                    break;
                case 3 :
                    this.parts[i] = new Part(this.name+"Part"+(i+1), true, 3, 5, null); 
                    this.parts[i].setImage(new Image(new File("src/main/Ressources/Wonders/"+this.name+"/Part_Constructions/wonder"+this.parts[i].getName()+".png").toURI().toString()));
                    break;
                case 4 :
                    this.parts[i] = new Part(this.name+"Part"+(i+1), false, 4, 7, null);
                    this.parts[i].setImage(new Image(new File("src/main/Ressources/Wonders/"+this.name+"/Part_Constructions/wonder"+this.parts[i].getName()+".png").toURI().toString()));
                    break;
            }
        }
    }
}