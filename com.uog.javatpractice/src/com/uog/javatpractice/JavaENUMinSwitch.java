package com.uog.javatpractice;
                                  //Here in this program we observe Java Enumeration in Switch Statement.

public class JavaENUMinSwitch {
	public enum Month{Jan, Feb, Mar, April, May, June, July, Aug, Sept, Oct, Nov, Dec}

	public static void main(String[] args) {
		 Month[] MonthNow = Month.values();
		 
		 for(Month Now : MonthNow)
		 {
			 switch (Now)    
             {    
                 case Jan: 
                 {
                     System.out.println("JANUARY :(");    
                     break; 
                 }
                 case Feb: 
                 {
                     System.out.println("FEBURARY :)");    
                     break;  
                 }
                 case Mar: 
                 {
                     System.out.println("MARCH :P");    
                     break;
                 }
                 case April: 
                 {
                     System.out.println("APRIL :&");    
                     break; 
                 }
                 case May: 
                 {
                     System.out.println("MAY :>");    
                     break; 
                 }
                 case June: 
                 {
                     System.out.println("JUNE :<");    
                     break;
                 }
                 case July:
                 {
                     System.out.println("JULY <@_@>");    
                     break;
                 }
                 case Aug:
                 {
                	 System.out.println("AUGUST :)");
                	 break;
                 }
                 case Sept:
                 {
                	 System.out.println("SEPTEMBER @_@");
                	 break;
                 }
                 case Oct:
                 {
                	 System.out.println("OCTOBER :)");
                	 break;
                 }
                 case Nov:
                 {
                	 System.out.println("NOVEMBER #_#");
                	 break;
                 }
                 case Dec:
                 {
                	 System.out.println("DECEMBER :P");
                	 break;
                 }
             }    
		 }
	}
}
