package com.sevenwonders;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private GameController gameController; 
    private List<Player> playerList = new LinkedList(); 

    public Game(List playerList){
        this.playerList = playerList; 
    }

    public List getPlayerList(){return this.playerList;}
    public void setPlayerList(List playeList){this.playerList = playeList;}

    public GameController getGameController(){return this.gameController;}
    public void setGameController(GameController gameController){this.gameController = gameController; }
}
