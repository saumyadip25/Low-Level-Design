package com.demo.enums;

public enum ParkingSpotType {
    SMALL(100), MEDIUM(200), LARGE(300);
    private int cost;
    ParkingSpotType(int cost) {
        this.cost=cost;
    }

    public int getCost() {
        return cost;
    }
}
