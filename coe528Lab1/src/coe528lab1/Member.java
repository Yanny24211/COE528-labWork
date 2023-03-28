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
public class Member extends Passenger{
    private int yearsOfMembership;
    
    public Member(String name, int age, int years){
        super(name, age); 
        this.yearsOfMembership = years; 
    }
    
    public int getYearsOfMembership(){
        return this.yearsOfMembership; 
    }
    
    public void setYearsOfMembership(int years){
        this.yearsOfMembership = years; 
    }
    
    @Override 
    public double applyDiscount(double p){
        if(this.yearsOfMembership > 5){
            return p = p/2; 
        }
        else if(this.yearsOfMembership > 1 && this.yearsOfMembership < 5){
            return p = p-(0.1*(p)); 
        }
        else{
            return p; 
        }
    }
}
