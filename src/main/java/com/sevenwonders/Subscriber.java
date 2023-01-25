package com.sevenwonders;

public interface Subscriber {
    void update(Game game); 
    GameMaster getMaster();
    
}
