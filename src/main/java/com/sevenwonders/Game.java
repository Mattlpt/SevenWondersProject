package com.sevenwonders;

import java.util.ArrayList;

import com.sevenwonders.controller.LauncherViewController;
import com.sevenwonders.controller.SetUpPlayerController;
import com.sevenwonders.controller.WonderSetUpController;
import com.sevenwonders.view.LauncherView;
import com.sevenwonders.view.PlayerSetUpView;
import com.sevenwonders.view.WonderSetUpView;

public class Game implements Subscriber {

    private ArrayList<Player> playerList;
    
    public LauncherView launcherView;
    PlayerSetUpView playerSetUpView;
    WonderSetUpView wonderSetUpView;
    
    LauncherViewController launcherViewController;
    SetUpPlayerController setUpPlayerController;
    WonderSetUpController wonderSetUpController;

    public Game() {
        this.playerList = new ArrayList<Player>();

        this.launcherViewController = new LauncherViewController();
        this.setUpPlayerController = new SetUpPlayerController();
        this.wonderSetUpController = new WonderSetUpController();

        this.launcherView = new LauncherView();
        this.playerSetUpView = new PlayerSetUpView();
        this.wonderSetUpView = new WonderSetUpView();
    }

    
    

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

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }




    @Override
    public GameMaster getMaster() {
        // TODO Auto-generated method stub
        return null;
    }
}
