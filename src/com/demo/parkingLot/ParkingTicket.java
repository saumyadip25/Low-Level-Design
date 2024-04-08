package com.demo.parkingLot;

import com.demo.vehicle.Vehicle;

import java.time.LocalTime;

public class ParkingTicket {
    private String entranceID;
    private long entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    public ParkingTicket(String entranceID, long entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entranceID = entranceID;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public String getEntranceID() {
        return entranceID;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
