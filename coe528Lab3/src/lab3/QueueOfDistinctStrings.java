/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.util.ArrayList;
/**
 *
 * @author Yanny
 */
public class QueueOfDistinctStrings {
    // Overview: QueueOfDistinctStrings are mutable, bounded
    // collection of distinct strings that operate in
    // FIFO (First-In-First-Out) order.
    //
    // The abstraction function is:
    // a) Write the abstraction function here
    //  AF(c) = an abstract QueueOfDistinctStrings object: d 
    //          where: firstInQueue = d.items.get(0) and lastInQueue = d.items.get(d.items.size()-1)
    //          and: Queue follows a First In, First Out Structure (FIFO), all queue items are stored in an array list as strings
    //
    //
    // The rep invariant is:
    // b) Write the rep invariant here
    // RI(c) = false if elements are repeated in queue and if elements in queue are not all strings
    //           => for(int j = 0, j < d.items.size(), j++){
    //                  for(int i = 1, i < d.items.size(), i++){
    //                      d.items.get(j) == d.items.get(i);
    //                  }
    //              }
    //         = true otherwise
    //
    //the rep
    private ArrayList<String> items;
    // constructor
    
    public QueueOfDistinctStrings () {
    // EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }
    
    // MODIFIES: this
    // EFFECTS: Appends the element at the end of the queue
    // if the element is not in the queue, otherwise
    // does nothing.
    public void enqueue(String element) throws Exception {
        if(element == null) throw new Exception();
        if(false == items.contains(element))
        items.add(element);
    }
    
    public String dequeue() throws Exception {
    // MODIFIES: this
    // EFFECTS: Removes an element from the front of the queue
        if (items.size() == 0) throw new Exception();
        return items.remove(0);
    }
    
    public boolean repOK() {
    // EFFECTS: Returns true if the rep invariant holds for this
    // object; otherwise returns false
        for(int j = 0; j < this.items.size(); j++){
            for(int i = 1; i < this.items.size(); i++){
                if((this.items.get(j) == this.items.get(i)) && i != j){
                    return false; 
                }    
            }
        }
        return true; 
    }
    
    public String toString() {
    // EFFECTS: Returns a string that contains the strings in the
    // queue, the front element and the end element.
    // Implements the abstraction function.
        int endIndex = this.items.size() - 1; 
        String s = ""; 
        for(int i = 0; i < this.items.size(); i++){
            s+= this.items.get(i) + " "; 
        }
        return "The Queue consists of :{" + s + "}, where the first element is " + this.items.get(0) + " and the last element is " + this.items.get(endIndex); 
    }  
    
    //Class and Methods Tests
    public static void main (String[] args){
        QueueOfDistinctStrings queue = new QueueOfDistinctStrings();
        
        try{
        queue.enqueue("Apples");
        queue.enqueue("Oranges");
        queue.enqueue("Dragonfruit");
        queue.enqueue("Starfruit");
        queue.dequeue();
        }
        
        catch (Exception e){
            System.out.println(e);
        }
        
        queue.items.add("Apples");
        System.out.println(queue);
        System.out.println(queue.repOK());
    }

}
