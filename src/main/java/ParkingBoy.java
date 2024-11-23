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

        if (!parkingLot1.isFull()) {
            return parkingLot1.park(car);
        }
        return parkingLot2.park(car);
    }

    public Car fetch(Ticket ticket) {
        if (ticket.issuedParkingLot == null) {
            throw new RuntimeExceptionUnrecognizedParkingTicket();
        }
        return ticket.issuedParkingLot.fetch(ticket);
    }
}
