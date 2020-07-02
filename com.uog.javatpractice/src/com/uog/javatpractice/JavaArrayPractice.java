package com.uog.javatpractice;

public class JavaArrayPractice {

	public static void main(String[] args) {
		                                            //First I Initialize array here  
        int [] arr = new int [] {1, 2, 3, 4, 5}; 
        
        System.out.println("This is Usama's Orignal and Authentic Array :) : ");  
        
        for (int Usama = 0;  Usama < arr.length;  Usama++)
        {  
            System.out.print(arr[Usama] + "  ");  
        }  
        System.out.println();                       //This prints a emptyLine for Spacing  
        
        System.out.println("This is the Usama's Authentic Array Finally In Reverse Order : ");  
        
                                                   //Here I put Loop through which the array in reverse order  
        for (int Raheem = arr.length-1;  Raheem >= 0; Raheem--) 
        {  
            System.out.print(arr[Raheem] + "  ");  
        }  
    }  
}


