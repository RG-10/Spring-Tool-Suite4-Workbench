package com.uog.javatpractice;
                                           // This program is for Wrapping in Switch Statement.
public class JavaWrapperSwitch {

	public static void main(String[] args) {
		 Integer UsamaAge = 20;        
         switch (UsamaAge)  
         {  
             case (16):            
                 System.out.println("Usama is Teenager :)");  
                 break;  
             case (20):                
                 System.out.println("Usama is Mature now and able to do Volunteering Stuff :P");  
                 break;  
             case (65):                
                 System.out.println("Usama is a Senior Citizen now Crap :(");  
                 break;  
             default:  
                 System.out.println("Please give Usama Valid Infromation :<");  
                 break;  
         }        
	}

}
