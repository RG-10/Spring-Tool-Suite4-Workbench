package com.uog.javatpractice;

public class JavaUsamaSelectionSort {
	public static void UsamaSelectionSort (int[] arr){ 
		
        for (int u = 0;    u < arr.length - 1;  u++)  
        {  
            int index = u;  
            
            for (int r = u + 1; r < arr.length; r++){ 
            	
                if (arr[r] < arr[index]){ 
                	
                    index = r;                   //searching for lowest index  
                }  
            }  
            int UsamaSmallerNumber = arr[index];
            
            arr[index] = arr[u];  
            
            arr[u] = UsamaSmallerNumber;  
        }  
    }  
	

	public static void main(String[] args) {
		int[] arr1 = {12,45,66,3,67,99,77,98}; 
		
        System.out.println("Before Selection Sort");  
        for(int u:arr1){ 
        	
            System.out.print(u+" ");  
        }  
        
        System.out.println();  
          
        UsamaSelectionSort(arr1);               //sorting array using selection sort  
         
        System.out.println("After Selection Sort");
        
        for(int u:arr1){  
        	
            System.out.print(u+" ");  
        }  
    }  
}


