package com.uog.javatpractice;

public class JavaPalindromeNum {

	public static void main(String[] args) {
		int remainder;
		int Sum = 0;
		int temp;
		int Num = 676;
		
		temp = Num;
		while(Num>0) {
			remainder = Num % 10;       //This gets the remainder value
			Sum = (Sum * 10) + remainder;
			Num = Num / 10;
		}
		
		if(temp == Sum) 
			System.out.println("The Num Usama Typed here is a Palindrom Number :) ");
		else
			System.out.println("The number you entered is not a Palindrome Number :(");
	}

}
