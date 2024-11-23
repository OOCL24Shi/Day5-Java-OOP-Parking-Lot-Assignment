public class ParkingBoy {

    public ParkingLot parkingLot1;
    public ParkingLot parkingLot2;

    public ParkingBoy(int positionsOfParkingLot1){

        this.parkingLot1 =new ParkingLot(positionsOfParkingLot1);
        this.parkingLot2 = new ParkingLot(0);
    }

    public ParkingBoy(int positionsOfParkingLot1, int positionsOfParkingLot2){

        this.parkingLot1 =new ParkingLot(positionsOfParkingLot1);
        this.parkingLot2 = new ParkingLot(positionsOfParkingLot2);
    }

    public Ticket park(Car car) {
        return parkingLot1.park(car);
    }

}
