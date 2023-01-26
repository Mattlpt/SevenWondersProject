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

}
