/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.util.ArrayList; 

/**
 *
 * @author Yanny
 */
public class FoodCategory extends FoodComponent{
    private ArrayList<FoodComponent> foodComp; 
    private final String name; 
    private double price; 
    
    public FoodCategory(String name){
        this.name = name;
        foodComp = new ArrayList<>(); 
    }
    
    public void add(FoodComponent x){
        foodComp.add(x); 
    }
    
    public void remove(FoodComponent y){
        foodComp.remove(y); 
    }
    
    @Override
    public double getPrice(){
        price = 0; 
        for(int i = 0; i < foodComp.size(); i++){
            price += foodComp.get(i).getPrice(); 
        }
        return price; 
    }
    
    @Override
    public void print(int level){
        String tab = " "; 
        for(int i = 0; i < level; i++){
            tab += "\t";
        }
        level++;
        
        System.out.println(tab + "Food Category (" + name + ", " + this.getPrice() + ") contains:");
        for (int i = 0; i < foodComp.size(); i++){
            foodComp.get(i).print(level); 
        }
    }
}
