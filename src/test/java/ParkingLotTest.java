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
        assertThrows(RuntimeExceptionUnrecognizedParkingTicket.class, () ->
                parkingLot.fetch(wrongTicket), "Unrecognized parking ticket.");
    }

    //Story 1 Case 5
    //Updated for Story 2 Case 2
    @Test
    void should__when__given_() {
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        //When

        //Then
        assertThrows(RuntimeExceptionUnrecognizedParkingTicket.class, () ->
                parkingLot.fetch(ticket), "Unrecognized parking ticket.");
    }

    //Story 1 Case 6
    //Updated for Story 2 Case 3
    @Test
    void should_return_error_when_park_given_no_positions() {
        //Given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }
        //When

        //Then
        assertThrows(RuntimeExceptionNoAvailablePosition.class, () ->
                parkingLot.park(car), "No available position.");
    }

    //Story 3 Case 1
    @Test
    void should_return_a_ticket_when_park_given_a_parking_boy_a_parkinglot() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Car car = new Car();
        //When
        Ticket ticket = parkingBoy.park(car);

        //Then
        assertNotNull(ticket);
    }

    //Story 3 Case 2
    @Test
    void should_return_a_car_when_fetch_given_a_parking_boy_a_parkinglot() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //When
        Car fetchedCar = parkingBoy.fetch(ticket);

        //Then
        assertEquals(car, fetchedCar);
    }

    //Story 3 Case 3
    @Test
    void should_return_right_car_when_fetch_given_a_parking_boy_two_different_tickets() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        //When
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);
        //Then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }

    //Story 3 Case 4
    @Test
    void should_return_error_msg_when_boy_fetch_given_a_unrecogzied_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Ticket wrongTicket = new Ticket();
        //When

        //Then
        assertThrows(RuntimeExceptionUnrecognizedParkingTicket.class, () ->
                parkingBoy.fetch(wrongTicket), "Unrecognized parking ticket.");
    }
    //Story 3 Case 5
    @Test
    void should_return_error_msg_when_boy_fetch_given_a_used_ticket(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy(10);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //When
        parkingBoy.fetch(ticket);
        
        //Then
        assertThrows(RuntimeExceptionUnrecognizedParkingTicket.class, () ->
                parkingBoy.fetch(ticket), "Unrecognized parking ticket.");
    }
    //Story 3 Case 6
    @Test
    void should_return_error_msg_when_boy_park_given_no_positions(){
        //Given only 1 position in the parking lot
        ParkingBoy parkingBoy = new ParkingBoy(1);
        Car car1 = new Car();
        Car car2 = new Car();
        //When
        parkingBoy.park(car1);
        
        //Then
        assertThrows(RuntimeExceptionNoAvailablePosition.class, () ->
                parkingBoy.park(car2), "No available position.");
    }
    //Story 4 Case 1
    @Test
    void should_park_in_1st_when_boy_park_given_2_not_full_parking_lot(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy(10, 10);
        Car car = new Car();
        //When
        Ticket ticket = parkingBoy.park(car);

        //Then
        assertEquals(ticket.issuedParkingLot, parkingBoy.parkingLot1);
    }
    //Story 4 Case 2
    @Test
    void should_park_in_2nd_when_boy_park_given_2_not_full_parking_lot(){
        //Given 2 parking lots with 1 position each
        ParkingBoy parkingBoy = new ParkingBoy(1, 1);
        Car car1 = new Car();
        Car car2 = new Car();
        //When
        parkingBoy.park(car1);
        Ticket ticket = parkingBoy.park(car2);
        //Then
        assertEquals(ticket.issuedParkingLot, parkingBoy.parkingLot2);
    }
    //Story 4 Case 3
    @Test
    void should_return_right_car_when_boy_fetch_given_2_different_tickets_2_parkinglot(){
        //Given 2 parking lots with 1 position each
        ParkingBoy parkingBoy = new ParkingBoy(1, 1);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        //When
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);
        //Then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
        assertEquals(ticket1.issuedParkingLot, parkingBoy.parkingLot1);
        assertEquals(ticket2.issuedParkingLot, parkingBoy.parkingLot2);
    }
    //Story 4 Case 4
    @Test
    void should_return_error_msg_when_boy_fetch_given_a_unrecognized_ticket_2_parking_lot(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy(10, 10);
        Ticket wrongTicket = new Ticket();
        //When
        //Then
        assertThrows(RuntimeExceptionUnrecognizedParkingTicket.class, () ->
                parkingBoy.fetch(wrongTicket), "Unrecognized parking ticket.");
    }
    //Story 4 Case 5
    @Test
    void should_return_error_msg_when_boy_fetch_given_a_used_ticket_2_parking_lot(){
        //Given
        ParkingBoy parkingBoy = new ParkingBoy(10, 10);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //When
        parkingBoy.fetch(ticket);
        
        //Then
        assertThrows(RuntimeExceptionUnrecognizedParkingTicket.class, () ->
                parkingBoy.fetch(ticket), "Unrecognized parking ticket.");
        
    }
    //Story 4 Case 6
    @Test
    void should_return_error_msg_when_boy_park_given_2_full_parking_lot(){
        //Given 2 parking lots with 1 position each
        ParkingBoy parkingBoy = new ParkingBoy(1, 1);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        //When
        parkingBoy.park(car1);
        parkingBoy.park(car2);

        //Then
        assertThrows(RuntimeExceptionNoAvailablePosition.class, () ->
                parkingBoy.park(car3), "No available position.");
    }
    //Story 5 Case 1
    @Test
    void should_park_in_1st_when_smart_boy_park_given_2_not_full_parking_lot(){
        //Given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(10, 10);
        Car car = new Car();
        //When
        Ticket ticket = smartParkingBoy.park(car);
        
        //Then
        assertEquals(ticket.issuedParkingLot, smartParkingBoy.parkingLot1);
    }
}
