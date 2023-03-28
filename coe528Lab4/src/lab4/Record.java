/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

/**
 *
 * @author Yanny
 */
public class Record {
    // Name of the associated file
    private static Record instance; 
    
    private final String filename = "record.txt";
    public Record() { 
        
    }
    
    File myFile = new File(filename);
    
    public static Record getInstance(){
        if (instance == null){
            instance = new Record(); 
        }
        return instance;
    }
    
    // Effects: Reads and prints the contents of the associated
    // file to the standard output.
    public void read() {
        try {
            Scanner read = new Scanner(myFile); 
            while(read.hasNextLine()){
                String text = read.nextLine(); 
                System.out.println(text); 
            }
            read.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // Effects: Appends the specified message, msg, to the
    // associated file.
    public void write(String msg) {
        try {
            FileWriter writeMsg = new FileWriter(filename, true); 
            writeMsg.write(msg); 
            writeMsg.close(); 
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    // Fill the blank below that obtains the sole instance
    // of the Record class.
    // (You should not invoke the Record constructor here.)
        Record r = Record.getInstance();
    // Do not modify the code below
        r.write("Hello-1\n");
        r.write("Hello-2\n");
        System.out.println("Currently the file record.txt " +
        "contains the following lines:");
        r.read();
    }
}
