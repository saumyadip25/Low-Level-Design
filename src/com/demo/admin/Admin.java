package com.demo.admin;

import com.demo.enums.ParkingSpotType;
import com.demo.parkingLot.*;

import java.util.Random;
import java.util.UUID;

public class Admin {
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public void addParkingFloor(int floorNumer){
        ParkingFloor parkingFloor=new ParkingFloor(floorNumer);
        ParkingLot.getInstance().getParkingFloors().add(parkingFloor);
        System.out.println("Parking Floor with floor number: "+floorNumer+" added in Parking Lot.");
    }

    public ParkingSpot addParkingSpot(int floorNumber, ParkingSpotType parkingSpotType){
        ParkingSpot parkingSpot=new ParkingSpot(UUID.randomUUID().toString(),parkingSpotType);
        for(ParkingFloor parkingFloor: ParkingLot.getInstance().getParkingFloors()){
            if(parkingFloor.getFloorNumber()==floorNumber){
                parkingFloor.addParkingSpot(parkingSpot);
                System.out.println("Parking spot: "+parkingSpot.getId()+" of type " + parkingSpot.getParkingSpotType()
                        +" added in parking floor: "+floorNumber);
                break;
            }
        }
        return parkingSpot;
    }

    public void removeParkingSpot(int floorNumber, ParkingSpot parkingSpot){
        for(ParkingFloor parkingFloor: ParkingLot.getInstance().getParkingFloors()){
            if(parkingFloor.getFloorNumber()==floorNumber){
                parkingFloor.removeParkingSpot(parkingSpot);
                System.out.println("Parking spot: "+parkingSpot.getId()+" removed in parking floor: "+floorNumber);
            }
        }
    }

    public Entrance addEntrance(String entranceID){
        Entrance entrance=new Entrance(entranceID);
        ParkingLot.getInstance().getEntrances().add(entrance);
        System.out.println("Entrance : "+entrance.getId()+" added in the Parking Lot.");
        return entrance;
    }

    public Exit addExit(String exitID){
        Exit exit=new Exit(exitID);
        ParkingLot.getInstance().getExits().add(exit);
        System.out.println("Exit : "+exit.getId()+" added in the Parking Lot.");
        return exit;
    }

}
