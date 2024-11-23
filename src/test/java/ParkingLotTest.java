import org.junit.jupiter.api.Test;

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
}
