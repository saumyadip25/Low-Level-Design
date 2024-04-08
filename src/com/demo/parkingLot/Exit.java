package com.demo.parkingLot;

import com.demo.enums.ParkingSpotType;
import com.demo.vehicle.Vehicle;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Exit {
    private String id;

    public String getId() {
        return id;
    }

    public Exit(String id) {
        this.id = id;
    }


    public long getParkingCost(ParkingSpotType parkingSpotType,long entryTime){
        long exitTime=System.currentTimeMillis();
        return (exitTime-entryTime+1)*parkingSpotType.getCost();
    }
    public void exitVehicle(ParkingTicket parkingTicket){
        for(ParkingFloor parkingFloor:ParkingLot.getInstance().getParkingFloors()){
            ParkingSpot parkingSpot=parkingTicket.getParkingSpot();
            Map<ParkingSpotType, List<ParkingSpot>> occupiedParkingSpots=parkingFloor.getOccupiedParkingSpots();
            Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots=parkingFloor.getFreeParkingSpots();
            if(occupiedParkingSpots.get(parkingSpot.getParkingSpotType()).contains(parkingSpot)){
                // remove the vehicle from occupied parking spots
                occupiedParkingSpots.get(parkingSpot.getParkingSpotType()).remove(parkingSpot);
                System.out.println("Total cost associated with Vehicle : "+parkingSpot.getVehicle().getVehicleNumber()
                        + " is : "+getParkingCost(parkingSpot.getParkingSpotType(),parkingTicket.getEntryTime()));
                System.out.println("Vehicle " + parkingSpot.getVehicle().getVehicleNumber() + " Exited the parking spot : " + parkingSpot.getId() + " in floor "+parkingFloor.getFloorNumber());
                // set the spot free
                parkingSpot.setFree(true);
                // un assign the vehicle
                parkingSpot.assignVehicle(null);
                // add free spot to free parking spots
                freeParkingSpots.get(parkingSpot.getParkingSpotType()).add(parkingSpot);
            }
        }

    }
}
