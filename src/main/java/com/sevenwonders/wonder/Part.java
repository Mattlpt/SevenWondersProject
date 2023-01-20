package com.sevenwonders.wonder;

public class Part {
    private String name;
    private boolean same;
    private int count;
    private int vicoryPoint;
    private String bonus;
    private Boolean isBuilt;

    public Part(String name, boolean same, int count, int vicoryPoint, String bonus) {
        this.name = name;
        this.same = same;
        this.count = count;
        this.vicoryPoint = vicoryPoint;
        this.bonus = bonus;
        this.isBuilt = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean getSame() {
        return this.same;
    }

    public int getCount() {
        return this.count;
    }

    public int getVictoryPoint() {
        return this.vicoryPoint;
    }

    public String getBonus() {
        return this.bonus;
    }

    public boolean getIsBuilt() {
        return this.isBuilt;
    }

}
