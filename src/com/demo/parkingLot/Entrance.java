package com.demo.parkingLot;

import com.demo.parkingStrategy.FirstComeFirstServeParkingStrategy;
import com.demo.parkingStrategy.ParkingStrategy;
import com.demo.vehicle.Vehicle;

import java.time.LocalTime;

public class Entrance {
    private String id;

    public Entrance(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ParkingTicket enterVehicle(Vehicle vehicle) throws Exception {
        ParkingStrategy parkingStrategy=new FirstComeFirstServeParkingStrategy();
        ParkingSpot parkingSpot=parkingStrategy.parkingStrategy(vehicle);

        return new ParkingTicket(id,System.currentTimeMillis(),vehicle,parkingSpot);
    }

}
