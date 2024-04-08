package com.demo.parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private String id;
    private List<ParkingFloor> parkingFloors;
    private List<Entrance> entrances;
    private List<Exit> exits;
    private static ParkingLot parkingLot=null;

    private ParkingLot() {
        this.id = UUID.randomUUID().toString();
        this.parkingFloors = new ArrayList<>();
        this.entrances = new ArrayList<>();
        this.exits = new ArrayList<>();
    }

    public static ParkingLot getInstance(){
        if(parkingLot==null){
            parkingLot= new ParkingLot();
        }
        return parkingLot;
    }

    public String getParkingLotID() {
        return id;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<Entrance> getEntrances() {
        return entrances;
    }

    public List<Exit> getExits() {
        return exits;
    }
}
