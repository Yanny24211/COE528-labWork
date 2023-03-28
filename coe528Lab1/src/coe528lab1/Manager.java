/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yanny
 */
public class Manager {
    ArrayList<Flight> flights; 
    ArrayList<Ticket> tickets; 
    
    public Manager(){
        flights = new ArrayList<Flight>();
        tickets = new ArrayList<Ticket>();
    }
    
    public ArrayList<Flight> getFlights()
    {
        return flights;
    }
    
    public ArrayList<Ticket> getTickets()
    {
        return tickets;
    }

    public void createFlights(){ 
        Scanner userIn = new Scanner(System.in);
        Scanner userIn2 = new Scanner(System.in); 
        String response = "n";  
        do{
            System.out.println("Enter flight number, origin, destination, departure time, flight capcity and the original price"); 
            int flightNum = userIn.nextInt(); 
            String from = userIn.next();
            String to = userIn.next(); 
            String departureTime = userIn.nextLine();
            departureTime += userIn.next();
            departureTime += userIn.nextLine();
            int flightCap = userIn.nextInt(); 
            double ogPrice = userIn.nextDouble(); 
            flights.add(new Flight(flightNum, from, to, departureTime, flightCap, ogPrice));   
            System.out.println("Would you like to continue? (y/n)"); 
            response = userIn2.nextLine(); 
            
        }while(response.equalsIgnoreCase("y"));
        
    }
    
    public void displayAvailableFlights(String origin, String destination){
        boolean found = false;  
        System.out.println("Availible flights from "+origin+" to "+destination+": "); 
        for(Flight flight : flights){
            if(flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination) && flight.getNumberOfSeatsLeft() != 0){
                System.out.println(flight);    
                found = true; 
            }
        }
        if(found == false){
            System.out.println("No Availible flights in this route"); 
        }     
    }
    
    public Flight getFlight(int flightNumber){
        boolean found = false; 
        for(Flight Flight: flights){
            if(flightNumber == Flight.getFlightNumber()){
                found = true; 
                return Flight; 
            }
        }
        if(found == false){
            System.out.println("No flight with the following flight number exists"); 
            return null; 
        }
        return null; 
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        if(getFlight(flightNumber)!= null && getFlight(flightNumber).bookASeat() == true){
            Flight f = getFlight(flightNumber); 
            f.bookASeat(); 
            double price = p.applyDiscount(f.getOriginalPrice()); 
            tickets.add(new Ticket(p, f, price)); 
        }    
        
    }
    
    public static void main(String[] args){
        Passenger john = new Member("John", 70, 30); 
        Passenger julie = new NonMember("Julie", 70); 
        Passenger jack = new NonMember("Jack", 25); 
        Manager jill = new Manager();  
        jill.createFlights();  
        jill.displayAvailableFlights("Toronto", "India");
        System.out.println(jill.getFlight(1030)); 
        jill.bookSeat(100, john); 
        jill.bookSeat(100, julie);
        jill.bookSeat(1030, jack);
        System.out.println(jill.getFlights()); 
        System.out.println(jill.getTickets()); 
    }
}
