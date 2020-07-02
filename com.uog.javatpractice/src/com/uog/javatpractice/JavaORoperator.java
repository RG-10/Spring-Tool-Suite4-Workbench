package com.uog.javatpractice;

public class JavaORoperator {

	public static void main(String[] args) {
		int Usama = 100;  
		int Raheem = 50;  
		int Gondal = 400; 

		System.out.println(Usama>Raheem  ||  Usama<Gondal);           //true || true = true  
		System.out.println(Usama>Raheem  ||  Usama<Gondal);           //true | true = true  
		                   
		                        // Logical vs Bitwise ---------  || vs |
		
		
		System.out.println(Usama>Raheem  ||  Usama++<Gondal);         //true || true = true  
		System.out.println(Usama);                                    //100 because second condition is not checked  
		System.out.println(Usama>Raheem  ||  Usama++<Gondal);         //true | true = true  
		System.out.println(Usama);                                    //101 because second condition is checked 

	}

}
