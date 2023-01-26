package com.sevenwonders;

import java.util.ArrayList;

import com.sevenwonders.controller.LauncherViewController;
import com.sevenwonders.controller.SetUpPlayerController;
import com.sevenwonders.controller.WonderSetUpController;
import com.sevenwonders.view.LauncherView;
import com.sevenwonders.view.PlayerSetUpView;
import com.sevenwonders.view.WonderSetUpView;

public class Game implements Subscriber {

    GameMaster gameMaster;
    private ArrayList<Player> playerList;
    
    public LauncherView launcherView;
    public PlayerSetUpView playerSetUpView;
    public WonderSetUpView wonderSetUpView;
    
    public LauncherViewController launcherViewController;
    public SetUpPlayerController setUpPlayerController;
    public WonderSetUpController wonderSetUpController;

    public Game(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.playerList = new ArrayList<Player>();
        this.launcherViewController = new LauncherViewController(this.gameMaster);
        this.setUpPlayerController = new SetUpPlayerController(this.gameMaster);
        this.wonderSetUpController = new WonderSetUpController(this.gameMaster);

        this.launcherView = new LauncherView(this.launcherViewController.getHandler());
        this.playerSetUpView = new PlayerSetUpView(this.setUpPlayerController.getHandler());
        this.wonderSetUpView = new WonderSetUpView(this.wonderSetUpController.getHandler());
    }

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }
}
