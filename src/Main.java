import com.demo.admin.Admin;
import com.demo.enums.ParkingSpotType;
import com.demo.parkingLot.Entrance;
import com.demo.parkingLot.Exit;
import com.demo.parkingLot.ParkingSpot;
import com.demo.parkingLot.ParkingTicket;
import com.demo.vehicle.Bike;
import com.demo.vehicle.Car;
import com.demo.vehicle.Truck;
import com.demo.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome to our Parking Lot!");

        Admin admin=new Admin("Saumyadip");
        // adding new parking floor 1
        admin.addParkingFloor(1);
        // adding new parking floor 2
        admin.addParkingFloor(2);
        // adding new parking spot in floor 1 of SMALL type
        ParkingSpot parkingSpot1=null;
        parkingSpot1=admin.addParkingSpot(1, ParkingSpotType.SMALL);
        // adding new parking spot in floor 1 of MEDIUM type
        ParkingSpot parkingSpot2=null;
        parkingSpot2=admin.addParkingSpot(1, ParkingSpotType.MEDIUM);
        // adding new parking spot in floor 1 of LARGE type
        ParkingSpot parkingSpot3=null;
        parkingSpot3=admin.addParkingSpot(1, ParkingSpotType.LARGE);

        // adding new parking spot in floor 2 of SMALL type
        ParkingSpot parkingSpot4=null;
        parkingSpot4=admin.addParkingSpot(2, ParkingSpotType.SMALL);
        // adding new parking spot in floor 2 of MEDIUM type
        ParkingSpot parkingSpot5=null;
        parkingSpot5=admin.addParkingSpot(2, ParkingSpotType.MEDIUM);
        // adding new parking spot in floor 2 of LARGE type
        ParkingSpot parkingSpot6=null;
        parkingSpot6=admin.addParkingSpot(2, ParkingSpotType.LARGE);

        // removing parking spot in floor 2 of LARGE type
        admin.removeParkingSpot(2, parkingSpot6);

        // adding entrance 123
        Entrance entry1=admin.addEntrance("123");
        // adding entrance 456
        Entrance entry2=admin.addEntrance("456");

        // adding exit 123
        Exit exit1=admin.addExit("123");
        // adding exit 456
        Exit exit2=admin.addExit("456");
        // create a new car
        Vehicle car1=new Car("WB_Car");
        ParkingTicket parkingTicket1;
        try {
            // car1 enters entrance 123
            parkingTicket1 = entry1.enterVehicle(car1);
        }
        catch (Exception e){
            System.out.println("Vehicle " + car1.getVehicleNumber() + " can not enter the Parking lot due to no space!");
        }
        // create a new bike
        Vehicle bike1=new Bike("WB_Bike");
        ParkingTicket parkingTicket2;
        try {
            // bike1 enters entrance 123
            parkingTicket2 = entry1.enterVehicle(bike1);
        }
        catch (Exception e){
            System.out.println("Vehicle " + bike1.getVehicleNumber() + " can not enter the Parking lot due to no space!");
        }
        // create a new bike bike2
        Vehicle bike2=new Bike("WB_Bike2");
        ParkingTicket parkingTicket3 = null;
        try {
            // bike2 enters entrance 123
            parkingTicket3 = entry2.enterVehicle(bike2);
        }
        catch (Exception e){
            System.out.println("Vehicle " + bike2.getVehicleNumber() + " can not enter the Parking lot due to no space!");
        }

        // create a new bike bike3
        Vehicle bike3=new Bike("WB_Bike3");
        ParkingTicket parkingTicket4;
        try {
            // bike2 enters entrance 123 (Note the parking lot for bikes is full so exception will be thrown)
            parkingTicket4 = entry1.enterVehicle(bike3);
        }
        catch (Exception e){
            System.out.println("Vehicle " + bike3.getVehicleNumber() + " can not enter the Parking lot due to no space!");
        }
        
        // remove vehicle WB_Bike2 from parking lot
        exit1.exitVehicle(parkingTicket3);

        try {
            // bike3 enters entrance 123 (Now space is available since bike2 has left)
            parkingTicket3 = entry1.enterVehicle(bike3);
        }
        catch (Exception e){
            System.out.println("Vehicle " + bike3.getVehicleNumber() + " can not enter the Parking lot due to no space!");
        }
        ParkingTicket parkingTicket5;
        Vehicle truck1=new Truck("WB_Truck1");
        try {
            // truck1 enters entrance 456
            parkingTicket5 = entry2.enterVehicle(truck1);
        }
        catch (Exception e){
            System.out.println("Vehicle " + truck1.getVehicleNumber() + " can not enter the Parking lot due to no space!");
        }

        ParkingTicket parkingTicket6;
        Vehicle truck2=new Truck("WB_Truck2");
        try {
            // truck2 enters entrance 456
            // It cannot enter the parking lot since we had created 2 parking lot and then later admin removed one parking loy
            parkingTicket6 = entry2.enterVehicle(truck1);
        }
        catch (Exception e){
            System.out.println("Vehicle " + truck2.getVehicleNumber() + " can not enter the Parking lot due to no space!");
        }



    }
}