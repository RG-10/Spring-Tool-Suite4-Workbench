package com.uog.javatpractice;

public class JavaOperatorsLogicalBitwise {

	public static void main(String[] args) {
		int Usama = 10;  
		int Raheem = 5;  
		int Akhter = 20;  
		System.out.println(Usama<Raheem && Usama++<Akhter);           //false && true = false  
		System.out.println(Usama);                    //10 because second condition is not checked  
		System.out.println(Usama<Raheem && Usama++<Akhter);            //false && true = false  
		System.out.println(Usama);                    //11 because second condition is checked  
		} 
                          // In AND operator BOTH condition should be True.
	}


