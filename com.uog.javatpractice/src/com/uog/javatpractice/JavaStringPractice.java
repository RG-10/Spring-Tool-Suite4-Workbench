package com.uog.javatpractice;

public class JavaStringPractice {

	public static void main(String[] args) {
		
		String s1 = "Usama Raheem Gondal";       //The Name which will be torn into pieces :)
		
        int len = s1.length(); 
        
        int temp = 0; 
        
                                                 //The specific formula is used in it n*(n+1)/2  
        String arr[] = new String[len*(len+1)/2];  
  
                                                 //This loop maintains the starting character  
        for(int i = 0;  i < len;  i++) { 
        	
                                                 //This loop adds the next character every iteration for the subset to 
        	                                     //form and add it to the array  
            for(int j = i;  j < len;  j++) { 
            	
                arr[temp] = s1.substring(i, j+1);  
                temp++;  
            }  
        }  
  
                                                 //Now this loop prints all the subsets formed from the string.  
        System.out.println("All the required subsets for given string are: ");  
        
        for(int i = 0;  i < arr.length;  i++) {  
        	
            System.out.println(arr[i]);  
        }  
    }  

}


