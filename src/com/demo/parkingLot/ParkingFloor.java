package com.demo.parkingLot;

import com.demo.enums.ParkingSpotType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    private Map<ParkingSpotType,List<ParkingSpot>> freeParkingSpots;
    private Map<ParkingSpotType,List<ParkingSpot>> occupiedParkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.freeParkingSpots = new HashMap<>();
        this.occupiedParkingSpots = new HashMap<>();
        // setting freeParkingSpots and occupiedParkingSpots at the beginning
        freeParkingSpots.put(ParkingSpotType.LARGE,new ArrayList<>());
        freeParkingSpots.put(ParkingSpotType.MEDIUM,new ArrayList<>());
        freeParkingSpots.put(ParkingSpotType.SMALL,new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotType.LARGE,new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotType.MEDIUM,new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotType.SMALL,new ArrayList<>());
    }

    public void setFreeParkingSpots(Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }

    public void setOccupiedParkingSpots(Map<ParkingSpotType, List<ParkingSpot>> occupiedParkingSpots) {
        this.occupiedParkingSpots = occupiedParkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        ParkingSpotType parkingSpotType=parkingSpot.getParkingSpotType();
        List<ParkingSpot> parkingSpotList=freeParkingSpots.get(parkingSpotType);
        parkingSpotList.add(parkingSpot);
        freeParkingSpots.put(parkingSpotType,parkingSpotList);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot){
        ParkingSpotType parkingSpotType=parkingSpot.getParkingSpotType();
        List<ParkingSpot> parkingSpotList=freeParkingSpots.get(parkingSpotType);
        if(!parkingSpotList.isEmpty()) {
            parkingSpotList.remove(parkingSpot);
            freeParkingSpots.put(parkingSpotType,parkingSpotList);
        }
    }

}
