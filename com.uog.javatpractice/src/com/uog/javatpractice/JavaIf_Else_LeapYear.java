package com.uog.javatpractice;
                                                // Program to understand the COncept of if-else statement.
public class JavaIf_Else_LeapYear {

	public static void main(String[] args) {
		int year = 2020;
		                                        // Here Condition is checked if one condition is true then it prints value
	    if(((year % 4 ==0) && (year % 100 !=0)) || (year % 400==0)){  
	        System.out.println("This is a LEAP YEAR");  
	    } else {  
	        System.out.println("This is a COMMON YEAR");  
	    }  
	
	}

}
