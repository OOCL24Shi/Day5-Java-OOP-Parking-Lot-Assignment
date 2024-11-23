import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    //Story 1 Case 1
    @Test
    void should_return_a_ticket_when_park_given_a_car() {
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
    void should_return_a_car_when_fetch_given_a_ticket() {
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //When
        Car fetchedCar = parkingLot.fetch(ticket);

        //Then
        assertEquals(car, fetchedCar);
    }

    //Story 1 Case 3
    @Test
    void should_return_right_car_when_fetch_given_two_different_tickets() {
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        //When
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);
        //Then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    //Story 1 Case 4
    //Updated for Story 2 Case 1
    @Test
    void should_return_nothing_when_fetch_given_a_wrong_ticket() {
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket wrongTicket = new Ticket();
        //When

        //Then
        assertThrows(RuntimeExceptionUnrecognizedParkingTicket.class,()->
            parkingLot.fetch(wrongTicket),"Unrecognized parking ticket.");
    }

    //Story 1 Case 5
    @Test
    void should__when__given_() {
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        //When
        Car fetchedCar = parkingLot.fetch(ticket);

        //Then
        assertNull(fetchedCar);
    }

    //Story 1 Case 6
    @Test
    void should_return_error_when_park_given_no_positions() {
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }
        //When
        Ticket newTicket = parkingLot.park(car);
        //Then
        assertNull(newTicket);
    }
}
