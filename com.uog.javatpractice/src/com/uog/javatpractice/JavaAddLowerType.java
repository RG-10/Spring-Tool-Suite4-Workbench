package com.uog.javatpractice;
                 // this is for Adding Lower Type
public class JavaAddLowerType {

	public static void main(String[] args) {
		byte Raheem = 32;
		byte Usama =  40;
		
		//byte c = a+b gives compiler eror because this is not correct way
        
		byte Gondal = (byte)(Raheem+Usama);
		
		System.out.println(Gondal);
	}

}
