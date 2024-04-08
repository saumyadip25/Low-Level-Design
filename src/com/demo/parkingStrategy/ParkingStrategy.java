package com.demo.parkingStrategy;

import com.demo.parkingLot.ParkingSpot;
import com.demo.vehicle.Vehicle;

public interface ParkingStrategy {
    public ParkingSpot parkingStrategy(Vehicle vehicle) throws Exception;
}
