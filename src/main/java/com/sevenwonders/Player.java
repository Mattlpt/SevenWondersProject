package com.sevenwonders;

public class Player {

    private String name ; 
    private int nb; 

    public Player(String name, int nb){
        this.name = name ; 
        this.nb = nb ;
    }

    public String getName(){return this.name;}
    public int getNb(){return this.nb;}

    public void setName(String name){this.name = name;}
    public void setNb(int nb){this.nb = nb;}
    
}
