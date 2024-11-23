public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(int positionsOfParkingLot1, int positionsOfParkingLot2) {
        super(positionsOfParkingLot1, positionsOfParkingLot2);
    }

    public Ticket park(Car car) {
        if (!parkingLot1.isFull() && parkingLot1.getAvailablePositionRate() >= parkingLot2.getAvailablePositionRate()) {
            return parkingLot1.park(car);
        } else {
            return parkingLot2.park(car);
        }
    }
}

