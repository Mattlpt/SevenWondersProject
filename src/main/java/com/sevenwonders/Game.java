package com.sevenwonders;

import java.util.ArrayList;

import com.sevenwonders.Card.DeckOfCards;
import com.sevenwonders.controller.LauncherViewController;
import com.sevenwonders.controller.PlayerSetUpViewController;
import com.sevenwonders.controller.PlayerViewController;
import com.sevenwonders.controller.WonderSetUpController;
import com.sevenwonders.view.LauncherView;
import com.sevenwonders.view.PlayerSetUpView;
import com.sevenwonders.view.PlayerView;
import com.sevenwonders.view.WonderSetUpView;
import com.sevenwonders.wonder.Wonder;

public class Game implements Subscriber {

    GameMaster gameMaster;
    private ArrayList<Player> playerList;
    private ArrayList<Wonder> wonderList;
    private DeckOfCards mainDraw;
    
    public LauncherView launcherView;
    public PlayerSetUpView playerSetUpView;
    public WonderSetUpView wonderSetUpView;
    public PlayerView playerView;
    
    public LauncherViewController launcherViewController;
    public PlayerSetUpViewController setUpPlayerController;
    public WonderSetUpController wonderSetUpController;
    public PlayerViewController playerViewController;

    public Game(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
        this.playerList = new ArrayList<Player>();
        this.wonderList = new ArrayList<Wonder>();
        this.mainDraw = new DeckOfCards(30, false);

        this.launcherViewController = new LauncherViewController(this.gameMaster);
        this.setUpPlayerController = new PlayerSetUpViewController(this.gameMaster);
        this.wonderSetUpController = new WonderSetUpController(this.gameMaster);
        this.playerViewController = new PlayerViewController(this.gameMaster);

        this.launcherView = new LauncherView(this.launcherViewController.getHandler());
        this.playerSetUpView = new PlayerSetUpView(this.setUpPlayerController.getHandler());
        this.wonderSetUpView = new WonderSetUpView(this.wonderSetUpController.getHandler());
        this.playerView = new PlayerView(this.playerViewController.getHandler());
    }

    @Override
    public void update(Game game) {
        // TODO Auto-generated method stub
        
    }

    public ArrayList<Player> getPlayerList() {
        return this.playerList;
    }

    public ArrayList<Wonder> getWonderList() {
        return this.wonderList;
    }

    public DeckOfCards getMainDraw() {
        return this.mainDraw;
    }
}
