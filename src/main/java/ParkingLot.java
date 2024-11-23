import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public int positionsOfParkingLot;
    private Map<Ticket, Car> parkingRecords = new HashMap<>();

    public ParkingLot(int positionsOfParkingLot) {
        this.positionsOfParkingLot = positionsOfParkingLot;
    }

    public Ticket park(Car car) {
        if (parkingRecords.size() >= positionsOfParkingLot) {
            throw new RuntimeExceptionNoAvailablePosition();
        }
        Ticket ticket = new Ticket();
        parkingRecords.put(ticket, car);
        return ticket;

    }

    public Car fetch(Ticket ticket) {
        Car car = parkingRecords.remove(ticket);
        if (car == null) {
            throw new RuntimeExceptionUnrecognizedParkingTicket();
        }
        return car;
    }
}
