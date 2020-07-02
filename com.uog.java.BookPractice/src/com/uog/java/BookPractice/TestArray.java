package com.uog.java.BookPractice;

import java.util.Scanner;

public class TestArray {

	public static void main(String[] args) {
		
		int a[] =  new int[10];
		
		 int x, i, c = 0;
		 
		 int ch;
		 
		 @SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		 
		 do {
			 System.out.println();
			 
			 System.out.println("Please Enter Choice :");
			 System.out.println("1. ADD Element");
			 System.out.println("2. DELETE Element");
			 System.out.println("3. SEARCH Element");
			 System.out.println("4. INSERT Element");
			 System.out.println("5. SHOW All");
			 System.out.println("6. EXIT");
			 ch = s1.nextInt();
		 
			 switch(ch)
			 {
			 case 1:   System.out.println("Please Enter DATA to ADD :");
			 x = s1.nextInt();
			 a[c++] = x;
			 break;
			 
			 case 2:    System.out.println("Please Enter DATA to DELETE:");
			 x = s1.nextInt();
			 i = 0;
			 for (i=0; i<c; i++)
			 {
				 if(a[i] == x)
					 break;
			 }
			 if(i != c) 
			 {
				 c--;
				 for(int k = i; k < c; k++)
					 a[k] = a[k+1];
			 } else 
			 {
				 System.out.println("DEAR DATA IS NOT FOUND :(");
				
			 }
			 break;
			 
			 case 3:
				 System.out.println("Please Enter DATA to SEARCH :");
				 x = s1.nextInt();
				 
				 for (i=0; i<c; i++)
				 {
					 if( a[i] == x)
						 break;
				 }
				 if(i != c)
				 {
					 System.out.println("DATA found at Location : " +i);
				 } else {
					 System.out.println("DEAR DATA IS NOT FOUND :(");
				 }
             break;
             
			 case 4:
				 System.out.println("Enter DATA to INSERT : ");
				 x = s1.nextInt();
				 System.out.println("PLease Enter Location");
				 int l = s1.nextInt();
				 for (i =c; i>l; i--)
				 {
					 a[i] = a[i-l];
				 }
				 a[i] = x;
				 c++;
			break;
			
			 case 5:
				 for (int k = 0; k<c; k++)
				 {
					 System.out.println(a[k]+"/t");
				 }
				 break;
				 
			 case 6: break;
			 
			 default: System.out.println("INVALID ENTRY TRY AGAIN :(");
			 }
			 } while (ch != 6);
		 }
	}
	


