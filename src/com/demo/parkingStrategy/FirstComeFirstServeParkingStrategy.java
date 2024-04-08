package com.demo.parkingStrategy;

import com.demo.enums.ParkingSpotType;
import com.demo.exception.SpotNotFoundException;
import com.demo.parkingLot.ParkingFloor;
import com.demo.parkingLot.ParkingLot;
import com.demo.parkingLot.ParkingSpot;
import com.demo.vehicle.Bike;
import com.demo.vehicle.Car;
import com.demo.vehicle.Vehicle;

import java.util.List;
import java.util.Map;

public class FirstComeFirstServeParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot parkingStrategy(Vehicle vehicle) throws Exception {
        try {
            ParkingSpotType parkingSpotTypeForVehicle = ParkingSpotType.LARGE;
            if (vehicle instanceof Car) {
                parkingSpotTypeForVehicle = ParkingSpotType.MEDIUM;
            } else if (vehicle instanceof Bike) {
                parkingSpotTypeForVehicle = ParkingSpotType.SMALL;
            }

            boolean isVehicleAssigned=false;
            for (ParkingFloor parkingFloor : ParkingLot.getInstance().getParkingFloors()) {
                Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots = parkingFloor.getFreeParkingSpots();
                Map<ParkingSpotType, List<ParkingSpot>> occupiedParkingSpots = parkingFloor.getOccupiedParkingSpots();
                if(!freeParkingSpots.get(parkingSpotTypeForVehicle).isEmpty()){
                   List <ParkingSpot> parkingSpotList=freeParkingSpots.get(parkingSpotTypeForVehicle);

                   ParkingSpot parkingSpot=freeParkingSpots.get(parkingSpotTypeForVehicle).get(0);
                   freeParkingSpots.get(parkingSpotTypeForVehicle).remove(0);
                   parkingFloor.setFreeParkingSpots(freeParkingSpots);
                   // assign the vehicle after finding the spot
                   parkingSpot.assignVehicle(vehicle);
                   // move the parking spot from free to occupied
                   occupiedParkingSpots.get(parkingSpotTypeForVehicle).add(parkingSpot);
                   isVehicleAssigned=true;
                   System.out.println("Vehicle : "+vehicle.getVehicleNumber()+" assigned a parking spot : "+parkingSpot.getId()+" in floor "+parkingFloor.getFloorNumber());
                   return parkingSpot;
                }
            }

            throw new SpotNotFoundException("No Spot Available to Park Vehicle " + vehicle.getVehicleNumber());
        }
        catch (Exception e){
            throw new Exception("Something went wrong while assigning Ticket "+vehicle.getVehicleNumber());
        }
}
}
