package com.uog.javatpractice;

public class JavaSwitchwithString {

	public static void main(String[] args) {
		
		                                   //Here we Declare the String variable  
	    String UsamaString = "Professional";  
	    int UsamaLevel = 0;  
	                                       //Here by Using String in Switch expression  
	    switch(UsamaString){    
	                                       //Now by Using String Literal in Switch case  
	    case "Beginner": UsamaLevel = 1;  
	    break;
	    
	    case "Intermediate": UsamaLevel = 2;  
	    break;    
	    
	    case "Professional": UsamaLevel = 3;  
	    break;    
	    
	    default: UsamaLevel = 0;  
	    break;  
	    }    
	    System.out.println("Usama Your Level of expertise is :)  : "+UsamaLevel);
	    System.out.println("You're a Compatible Professional Thanks to Your Brillient and MultiTalented Teacher DOC-NAUMAN :)");
		
	}

}
