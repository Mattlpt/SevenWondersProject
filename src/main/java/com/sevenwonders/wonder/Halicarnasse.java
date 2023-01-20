package com.sevenwonders.wonder;

import javafx.scene.paint.Color;

public class Halicarnasse extends Wonder{
    public Halicarnasse() {
        this.name = "Halicarnasse";
        this.color = Color.web("4f456d"); 
        this.parts = new Part[5];
    }
    
    @Override
    public void setParts() {
        for(int i=0; i<this.parts.length; i++) {
            switch(i) {
                case 0 :
                    this.parts[i] = new Part("part"+(i+1), false, 2, 3, null);
                    break;
                case 1 :
                    this.parts[i] = new Part("part"+(i+1), true, 2, 3, null);
                    break;
                case 2 :
                    this.parts[i] = new Part("part"+(i+1), false, 3, 6, null);
                    break;
                case 3 :
                    this.parts[i] = new Part("part"+(i+1), true, 3, 5, null);
                    break;
                case 4 :
                    this.parts[i] = new Part("part"+(i+1), false, 4, 7, null);
                    break;
            }
        }
    }
}
