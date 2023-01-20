package com.sevenwonders.wonder;

import javafx.scene.paint.Color;

public class Alexendrie extends Wonder{
    
    public Alexendrie() {
        this.name = "Alexandrie"; 
        this.color = Color.web("2a4f85"); ; 
        this.parts = new Part[5];
        setParts();

    }

    @Override
    public void setParts() {
        for(int i=0; i<this.parts.length; i++) {
            switch(i) {
                case 0 :
                    this.parts[i] = new Part("part"+(i+1), false, 2, 4, null);
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
