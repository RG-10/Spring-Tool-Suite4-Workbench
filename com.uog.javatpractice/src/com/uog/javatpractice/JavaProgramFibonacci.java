package com.uog.javatpractice;
                                          //This program is for Fibonacci num check.

public class JavaProgramFibonacci {

	public static void main(String[] args) {
		int Usama1 = 0, Usama2 = 1, Usama3,  Raheem,  count=10;  
		 System.out.print(Usama1+" "+Usama2);                   //This prints 0 and 1  
		  
		 for(Raheem = 2; Raheem < count;  ++Raheem)             //loop starts from 2 because 0 and 1 are already printed  
		 {  
		  Usama3 = Usama1 + Usama2;
		  
		  System.out.print(" "+Usama3);  
		  Usama1 = Usama2;
		  Usama2 = Usama3;  
		 }  


	}

}
