package com.uog.javatpractice;
                       //This program is for Overflowing in Java.
public class JavaOverFlow {

	public static void main(String[] args) {
		int Usama = 1200000;
		
		//OVERFLOW
		byte Raheem = (byte) Usama;
		
		System.out.println(Usama);
		System.out.println(Raheem);
	}

}
