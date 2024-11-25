import java.util.Arrays;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(int positionsOfParkingLot1, int positionsOfParkingLot2) {
        super(positionsOfParkingLot1, positionsOfParkingLot2);
    }


    public Ticket park(Car car) {
        if (parkingLot1.getAvailablePosition()>=parkingLot2.getAvailablePosition()) {
            return parkingLot1.park(car);
        } else {
            return parkingLot2.park(car);
        }
    }

}
