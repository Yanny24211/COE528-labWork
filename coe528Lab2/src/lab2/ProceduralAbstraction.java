/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author Yanny
 */
public class ProceduralAbstraction {
    public static int reverseFactorial(int x){
        double num = x; 
        int ans = 0; 
        for(int i = 2; num > i; i++){
            num = num/i;
            ans = i; 
            //System.out.println("Loop #: " + i + " Value of x: " + num); 
        }
        if(num > 1){
            return(ans + 1); 
        }
        else if(num == 1){
            return ans; 
        }
        return 1; 
    }
    
    public static boolean isMatrixNice(int[][] arr) {
        int rows = arr.length; 
        int columns = arr.length; 
        int sum = 0; 
        
        //Finds the sum for 1 column and sets that as the sum (since all sums should be the same it shouldnt matter which column/row is used)
        for(int j = 0; j < rows; j++){
            sum = sum + arr[0][j];
        }
        
        System.out.println("The Sum is: " + sum); 
        //Creates sum for all rows
        int rowsSum = 0; 
        int colSum = 0; 
        int diagSum1 = 0; 
        int diagSum2 = 0; 
        for(int i = 0; i < rows; i++){
            for(int k = 0; k < rows; k++){
                rowsSum+= arr[i][k];
            }        
        }
        //Creates sum for all columns
        for(int i = 0; i < columns; i++){
            for(int k = 0; k < columns; k++){
                colSum+= arr[k][i];
            }        
        }
        //Creates sum for diagonals 
        for(int i = 0; i < rows; i++){
            diagSum1+= arr[i][i]; 
        }
        
        for(int j = 0; j < rows; j++){
            diagSum2+= arr[rows-j-1][j];
        }
        if(rowsSum/rows == sum && colSum/rows == sum && diagSum1 == sum && diagSum2 == sum){
            System.out.println(sum); 
            return true; 
        }
        else{
            return false; 
        }
    }
    
    public static void main(String[] args){
        System.out.println("Q1: Reverse Factorial"); 
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter Number: "); 
        int z = scan.nextInt(); 
        System.out.println("The reverse factorial of " + z + " is " + reverseFactorial(z) + "\n");
        
        System.out.println("Q2: Is Matrix Nice?"); 
        Scanner matrix = new Scanner(System.in); 
        System.out.println("Enter # of rows and columns: "); 
        int rows = matrix.nextInt(); 
        int cols = rows; 
        int[][] arr = new int[rows][cols]; 
        System.out.println("Enter values for matrix (row by row): "); 
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < rows; j++){
                arr[i][j] = matrix.nextInt(); 
            }
        }
        System.out.println(isMatrixNice(arr)); 
    }
}


