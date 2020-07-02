package com.uog.javatpractice;

public class JavaPattrenPractice {

	public static void main(String[] args) {
		 int PattrenSize ;    
	       PattrenSize = 6;    
	       for (int i = PattrenSize; i != 0; i--)     
	       {    
	           for (int j = 0; j<PattrenSize-i; j++)    
	           {    
	               System.out.print(" ");    
	           }    
	           for (int k = 0; k < (2 * i - 1); k++)     
	           {    
	               System.out.print("#");    
	           }    
	           System.out.println(); 
	        }

       }
}
