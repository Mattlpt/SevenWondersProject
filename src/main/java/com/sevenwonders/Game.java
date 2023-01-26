package com.sevenwonders;

import java.util.ArrayList;
import java.util.List;

import com.sevenwonders.controller.PlayerViewController;

public class Game {

    /*
     *  Game ; model du jeu 
     */

    private List<Player> playerList = new ArrayList(); 

    public Game(){
    }

    public List getPlayerList(){return this.playerList;}
    public void setPlayerList(List playeList){this.playerList = playeList;}

    /*
     *  setPlayerNumber ; règle le nombre de joueur 
     */
    public void setPlayerNumber(String nbPlayerText) {
        int nbPlayerInt =Integer.parseInt(nbPlayerText);  
        if(nbPlayerInt > 1 && nbPlayerInt < 8){
            for(int i = 0; i < nbPlayerInt; i++){
                playerList.add(new Player("Player", i)); 
                for(int j = 1 ; j < playerList.size(); j++){
                    String playerNbString = Integer.toString(playerList.get(i).getNb());                   
                    String playerNameString = playerList.get(j).getName(); 
                    System.out.println(playerNameString+playerNbString);

                }
            }
        }
    }
}
