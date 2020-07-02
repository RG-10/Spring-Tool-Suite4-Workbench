package com.uog.javatpractice;
                                   //In this program we add short data type values.
public class JavaShortAddition {

	public static void main(String[] args) {
		short Usama = 50;  
		short Raheem = 10;  
		                                     //Usama+=Raheem;
		                                     //Usama = Usama + Raheem   internally so fine  
	    //Usama =Usama+Raheem;                  //Compile time error because 50+10=60 now integer 
		//we solve this problem by the following methode
		
		Usama = (short)(Usama+Raheem);       //we  done this by type casting now our value changed into integers.
		System.out.println(Usama);  
	}

}
