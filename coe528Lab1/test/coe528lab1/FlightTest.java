/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yanny
 */
public class FlightTest {
    /**
     * Test of Flight method, of class Flight.
     */
    private Flight f;
    
    @Before
    public void setUp() {
        f = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000, 1000.0);
    }
    
    @After
    public void tearDown() {
        f = null;
    }

    @Test
    public void testConstructor() {
        System.out.println("Constructor Test");
        f = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000, 1000.0);
        assertEquals(1030, f.getFlightNumber());
        assertEquals("Toronto", f.getOrigin());
        assertEquals("Kolkata", f.getDestination());
        assertEquals("03/02/99 7:50 pm", f.getDepartureTime());
        assertEquals(1000, f.getCapacity());
        assertEquals(1000.0, f.getOriginalPrice(), 0.0);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testInvalidConstructor(){
        System.out.println("Invalid Constructor Test");
        f = new Flight(1030, "Toronto", "Toronto", "03/02/99 7:50 pm", 1000, 1000.0);
    }
    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");       
        int expResult = 1030;
        assertEquals(expResult, f.getFlightNumber());     
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        int flightNumber = 3030;
        f.setFlightNumber(flightNumber);
        assertEquals(3030, f.getFlightNumber());
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        String expResult = "Toronto";
        String result = f.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String origin = "Edmonton";
        f.setOrigin(origin);
        assertEquals(origin, f.getOrigin());
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        String expResult = "Kolkata";
        String result = f.getDestination(); 
        assertEquals(expResult, result);
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String destination = "Florence";
        f.setDestination(destination);
        assertEquals(destination, f.getDestination());
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        String expResult = "03/02/99 7:50 pm";
        String result = f.getDepartureTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        String departure = "03/02/99 8:50 pm";
        f.setDepartureTime(departure);
        assertEquals(departure, f.getDepartureTime());
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        int expResult = 1000;
        int result = f.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int capacity = 2000;
        f.setCapacity(capacity);
        assertEquals(capacity, f.getCapacity()); 
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("getNumberOfSeatsLeft");
        int expResult = f.getCapacity();
        int result = f.getNumberOfSeatsLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("setNumberOfSeatsLeft");
        int numberOfSeatsLeft = 500;
        f.setNumberOfSeatsLeft(numberOfSeatsLeft);
        assertEquals(500, f.getNumberOfSeatsLeft()); 
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        double expResult = 1000.0;
        double result = f.getOriginalPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        double originalPrice = 1521.3;
        f.setOriginalPrice(originalPrice);
        assertEquals(originalPrice, f.getOriginalPrice(), 0.0); 
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
        f.setNumberOfSeatsLeft(1); 
        boolean result = f.bookASeat();
        assertTrue(result);
        assertFalse(f.bookASeat()); 
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Flight 1030, Toronto to Kolkata, 03/02/99 7:50 pm, original price: $1000.0";
        String result = f.toString();
        assertEquals(expResult, result);
    }
    
}
