package com.sevenwonders.wonder;

import java.io.File;

import javafx.scene.image.Image;

public class Part {
    private String name;
    private boolean same;
    private int count;
    private int vicoryPoint;
    private String bonus;
    private Boolean isBuilt;
    private Image image;

    public Part(String name, boolean same, int count, int vicoryPoint, String bonus) {
        this.name = name;
        this.same = same;
        this.count = count;
        this.vicoryPoint = vicoryPoint;
        this.bonus = bonus;
        this.isBuilt = false;
        this.image = new Image(new File("src/main/Ressources/Wonders/Alexandrie/Part_Constructions/wonder"+this.name+".png").toURI().toString());
    }

    public void setIsBuilt(Boolean bool) {
        this.isBuilt = bool;
    }

    public String getName() {
        return this.name;
    }

    public boolean getSame() {
        return this.same;
    }

    public int getCount() {
        return this.count;
    }

    public int getVictoryPoint() {
        return this.vicoryPoint;
    }

    public String getBonus() {
        return this.bonus;
    }

    public boolean getIsBuilt() {
        return this.isBuilt;
    }

    public Image getImage() {
        return this.image;
    }

}
