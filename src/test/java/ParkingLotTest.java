import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    //Story 1 Case 1
    @Test
    void should_return_a_ticket_when_park_given_a_car(){
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        //When
        Ticket ticket = parkingLot.park(car);
        
        //Then
        assertNotNull(ticket);
    }
    //Story 1 Case 2
    @Test
    void should_return_a_car_when_fetch_given_a_ticket(){
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //When
        Car fetchedCar = parkingLot.fetch(ticket);

        //Then
        assertEquals(car, fetchedCar);
    }
}
