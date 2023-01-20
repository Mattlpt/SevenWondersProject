package com.sevenwonders.wonder;

import javafx.scene.paint.Color;

public class Rhodes extends Wonder {
    public Rhodes() {
        this.name = "Rhodes";
        this.color = Color.web("cd4e49"); 
        this.parts = new Part[5];
        setParts();
    }

    @Override
    public void setParts() {
        for(int i=0; i< this.parts.length; i++) {
            switch(i) {
                case 0 :
                    this.parts[i] = new Part("part"+(i+1), true, 2, 4, null);
                    break;
                case 1 :
                    this.parts[i] = new Part("part"+(i+1), false, 2, 4, null);
                    break;
                case 2 :
                    this.parts[i] = new Part("part"+(i+1), false, 3, 5, null);
                    break;
                case 3 :
                    this.parts[i] = new Part("part"+(i+1), true, 3, 6, null);
                    break;
                case 4 :
                    this.parts[i] = new Part("part"+(i+1), false, 4, 7, null);
                    break;
            }
        }
    }
}
