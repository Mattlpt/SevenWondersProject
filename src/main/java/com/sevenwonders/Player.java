package com.sevenwonders;

import java.util.ArrayList;
import java.util.HashMap;

import com.sevenwonders.wonder.Wonder;

public class Player {

    private String name ;
    private Wonder wonder;
    private HashMap<String, Integer> resourceList;
    private int piece;
    private int count;  

    public Player(String name){
        this.name = name;
        this.wonder = null; 
        this.resourceList = new HashMap<String, Integer>();
        this.resourceList.put("Bois", 0);
        this.resourceList.put("Pierre", 0);
        this.resourceList.put("Papier", 0);
        this.resourceList.put("Verre", 0);
        this.count = 0;
    }

    public void setWonder(Wonder wonder) {
        this.wonder = wonder;
    }

    public void setCount(int nb) {
        this.count = nb;
    }

    public void setPiece(int nb) {
        this.piece = nb;
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

    public HashMap<String, Integer> getResourceList() {
        return this.resourceList;
    }

    public int getCount() {
        return this.count;
    }

    public int getPiece() {
        return this.piece;
    }
    
}