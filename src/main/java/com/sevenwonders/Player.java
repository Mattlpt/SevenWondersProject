package com.sevenwonders;

import com.sevenwonders.wonder.Wonder;

public class Player {

    private String name ;
    private Wonder wonder;  

    public Player(String name){
        this.name = name;
        this.wonder = null; 
    }

    public void setWonder(Wonder wonder) {
        this.wonder = wonder;
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public Wonder getWonder() {
        return this.wonder;
    }
    
}
