/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author Yanny
 */
public class FoodItem extends FoodComponent{
    private double price; 
    private String name; 
    
    public FoodItem(String name, double cost){
        this.name = name; 
        price = cost;
    }
    
    public double getPrice(){
        return price; 
    }
    
        
    @Override
    public void print(int level){
        String tab = " "; 
        for(int i = 0; i < level; i++){
            tab += "\t";
        }
        level++; 
        
        System.out.println(tab + "FoodItem: " + this.name + ", " + this.getPrice()); 
        
    }
}
