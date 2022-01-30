package System_Design.Object_oriented;


class Employee{
    long employeeId;
    String name;
    initiatePayment(); // call payemnt of floor

    Employee(String name){
        this.name = name;
    }
}

class Admin extends Employee{
    Employee(){
        super();
    }
    addFloor();
    removeFloor();
    updateLotName();
    reserveSpot();
}

class Attendant extends Employee{

}

class Gate{
    // must have methods which the entrance and exit gate classes can inherit or override
    long gateId;
    String gateType; // enum can be used
    boolean isSpotAvailable;

    // lot will be checked, spots on each floor can be checked by lot or floor
    if(areSpotsAvailable(long lotId)){
        generateTicket(); // call
        redirectToNearestSpot() {
            // some analytics here;
            // iterate over floors and assign first available spot
            bookSpot();
        }
    }

    bookSpot(long floorId, long spotId){
        // update status in db ticketid, spot id, floor id, registration number
        // call floor's assignSpot
    }

    removeSpot(Ticket ticket){
        // call floor removeSpot;
        // make Payment
    }

}


// must have info to uniquely identify a floor inside a lot
class ParkingFloor{
    // i think we can have unique ids or search in db for lot which has the id, but storing an 
    // extra id will help avoid db call

    long parkinglotId; 
    long floorId;
    // List<ParkingSpot> filledSpots;
    boolean isFull;
    List<ParkingSpot> availableSpots;

    boolean areSpotsAvailable(){
        if(availableSpots.size() == 0) return false;
        return true;
    }

    assignSpot(){
        // update lists
    }

    removeSpot(){
        // update lists
    }

}

// singleton
public class ParkingLot {
    long parkinglotId;
    List<EntranceGate> entranceGates;
    List<ExitGate> exitGates;
    List<ParkingFloor> floorList; // floorList can have display of avaialable spots
    HashMap<long, boolean> floorSpotMap;

    // search in each floor, check in db if any floor has spots


}


// new Ticket will have a new Payment object
class Ticket{
    String registrationNumber;
    String startTime, endTime;
    ParkingSpot parkingSpot;
    Payment payment;

    Ticket(){
        this.payment = new Payment();
        this.startTime = "";// currentTime,
        // endTime will be updated at exit gate and fare will be calculated
    }

    Ticket getTicket(String regNum, long parkinglotId){
        if (lot has no free spots) return null;
        return ticket;
    }

}

class Payment{
    long paymentId;
    long amount;
    String type; //can be enum

    boolean makePayment(long amt, String type){
        this.payment.amount = amt;
        this.payment.type = type;
        //pass this obj to third party payment service
        // and update the output
        if(success) return true;
        return false;
    }
}


class ParkingSpot{
    enum CarType{
        hatchback, sedan, SUV, bus, truck;
    };
    int row; int col; int floor;
}

public enum ParkingSpotType {
    HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
}

// class 
class Vehicle{
    String registrationNumber;
    enum type;
}






/**
parking lot table
id, name, no of spots, address, floor(json?)

floor/spot table
spot id, floor id, lot id

ticket table
ticket id, amount, registration Number, spot id, floor id

*/


/**
 design schema, that gives a clearer idea coz of ORM
 payment system needs to be integrated
 for one to one mapping we can use embedded class, it can create class in the same row,
 for one to many, use separate table
 payment can be stored as an embedded class in ticket class

 is it necessary to have an attendant class? can't we map the attendant id to ticket and
 the payemnt and ticket generation can be handled at exit gate?
 */