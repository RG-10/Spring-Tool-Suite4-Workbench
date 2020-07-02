package com.uog.javatpractice;
                                         // This program if for if-else-if statement in Java.
                                         // We make a grading program by using this statement.
public class JavaIf_else_If_Statement {

	public static void main(String[] args) {
		int marks = 97;  
	      
	    if(marks<50){  
	        System.out.println("This Particular Student is failed");  
	    }  
	    else if(marks>=50 && marks<60){  
	        System.out.println("This Student has D grade");  
	    }  
	    else if(marks>=60 && marks<70){  
	        System.out.println("This Student has C grade");  
	    }  
	    else if(marks>=70 && marks<80){  
	        System.out.println("This Student has B grade");  
	    }  
	    else if(marks>=80 && marks<90){  
	        System.out.println("This Student has A grade :)");  
	    }else if(marks>=90 && marks<100){  
	        System.out.println("This Student has A+ grade CONGRATULATIONS :)");  
	    }else{  
	        System.out.println("Invalid APPROACH PLEASE TRY AGAIN!");  
	    }  
	}  
	 
	}
