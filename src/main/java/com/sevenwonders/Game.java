package com.sevenwonders;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private ControllerGame gameController; 
    private List<Player> playerList = new LinkedList(); 

    public Game(List playerList){
        this.playerList = playerList; 
    }

    public List getPlayerList(){return this.playerList;}
    public void setPlayerList(List playeList){this.playerList = playeList;}

    public ControllerGame getGameController(){return this.gameController;}
    public void setGameController(ControllerGame gameController){this.gameController = gameController; }

    public void setPlayerNumber(String nbPlayerText) {
        int nbPlayerInt =Integer.parseInt(nbPlayerText);  
        if(nbPlayerInt > 1 && nbPlayerInt < 8){
            for(int i = 0; i < nbPlayerInt; i++){
                playerList.add(new Player("Player", i)); 
                for(int j = 0 ; j < playerList.size(); j++){
                    String playerNbString = Integer.toString(playerList.get(i).getNb());                   
                    String playerNameString = playerList.get(j).getName(); 
                    System.out.println(playerNameString+playerNameString);

                }
            }
        }
    }
}
