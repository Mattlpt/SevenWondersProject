package com.sevenwonders.wonder;

import javafx.scene.paint.Color;

public abstract class Wonder {
    protected String name;
    protected Color color; 
    protected Part[] parts;

    public Wonder() {}
    
    public Wonder(String name, int count) {
        this.name = name;
        this.parts = new Part[count];
    }

    public void setParts() {}

    public String getName() {return this.name;}

    public Color getColor() {return this.color;}

    public Part[] getParts() {return this.parts;}

    public String toString() {return this.name;}
}
