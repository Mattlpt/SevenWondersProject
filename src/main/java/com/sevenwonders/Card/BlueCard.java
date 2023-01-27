package com.sevenwonders.Card;

public class BlueCard extends Card {
    private int victoryPoint;

    public BlueCard(int nb) {
        this.color = "Blue";
        this.victoryPoint = nb;
    }

    public int getVictoryPoint() {
        return this.victoryPoint;
    }
}
