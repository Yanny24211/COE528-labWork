/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528lab1;

/**
 *
 * @author Yanny
 */
public class Flight {
    private int flightNumber; 
    private String origin;
    private String destination; 
    private String departure; 
    private int capacity; 
    private int numberOfSeatsLeft; 
    private double originalPrice; 

    public Flight(int flightNumber, String origin, String destination, String departure, int capacity, double originalPrice){
        if(origin.equals(destination)){
            throw new IllegalArgumentException("Origin and destination must be different"); 
        }
        else{
            this.flightNumber = flightNumber; 
            this.origin = origin; 
            this.destination = destination; 
            this.departure = departure; 
            this.capacity = capacity; 
            this.numberOfSeatsLeft = capacity; 
            this.originalPrice = originalPrice; 
        }
    }
    
    public int getFlightNumber(){
        return flightNumber; 
    }
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber; 
    }
    
    public String getOrigin(){
        return origin; 
    }
    public void setOrigin(String origin){
        this.origin = origin; 
    }
    
    public String getDestination(){
        return destination; 
    }
    public void setDestination(String destination){
        this.destination = destination; 
    }
    
    public String getDepartureTime(){
        return departure; 
    }
    public void setDepartureTime(String departure){
        this.departure = departure; 
    }
    
    public int getCapacity(){
        return capacity; 
    }
    public void setCapacity(int capacity){
        this.capacity = capacity; 
    }
    
    public int getNumberOfSeatsLeft(){
        return numberOfSeatsLeft; 
    }
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft){
        this.numberOfSeatsLeft = numberOfSeatsLeft;     
    }
    
    public double getOriginalPrice(){
        return originalPrice; 
    }
    public void setOriginalPrice(double originalPrice){
        this.originalPrice = originalPrice;
    }
    
    public boolean bookASeat(){
        if(numberOfSeatsLeft > 0){
            numberOfSeatsLeft--; 
            return true; 
        }
        else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return ("Flight " + this.flightNumber + ", " + this.origin + " to " + this.destination + ", " + this.departure + ", original price: $" + this.originalPrice); 
    }
    
    
    public static void main(String[] args){
        Flight delta = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 1000, 1000.0); 
        System.out.println(delta.toString()); 
    }
    
}