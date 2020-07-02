package com.uog.javatpractice;
                                        //This program is to understand nested if statement.
public class JavaNested_If_Statement {

	public static void main(String[] args) {
		
		int Usamaweight = 90;
		int UsamaAge  = 20;
		
		if(Usamaweight>=90) {
			if(UsamaAge>=20) {
				System.out.println("Usama Raheem is eligible to Donate BLOOD :)");
			}
		} else {                         // From this Step we understand Nested If else Statement.
			
			
			    System.out.println("AWWW Sorry Usama you are not eligible to donate BLOOD :("); 
		}
		
		
	}

}
