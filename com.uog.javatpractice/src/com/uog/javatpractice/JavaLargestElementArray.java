package com.uog.javatpractice;

public class JavaLargestElementArray {

	public static void main(String[] args) {
		
        int [] arr = new int [] {233324, 423534636,  3654654, 4534654}; 
        
                                        //Here i initialize Max  
        int max = arr[0];  
                                        //Loop through the array  
        for (int u = 0; u < arr.length; u++) {  
        	
                                        //Here i Compare elements of array with max  
           if(arr[u] > max)  
               max = arr[u];  
        }  
        System.out.println("The Largest element present in given array is :) : " + max);  
    }  

}