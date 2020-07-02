package com.uog.javatpractice;

public class JavaMatrixPractice {

	public static void main(String[] args) {
		int rows, column;
		int a[][] = {
				{ 1, 2, 3},
				{ 4, 5, 6},
				{ 7, 8, 9}		
		};
	    
		rows = a.length;
		column = a[0].length;
		
		if(rows != column) {
			System.out.println("Usama! the matrix you commands should be Square Matrix :)");
		} else {
			System.out.println("There you go Usama! this is Upper Triangular matrix :P");
		}
		//Performs required operation to convert given matrix into upper triangular matrix 
		
		for(int i = 0; i < rows; i++)
		{
		for(int j = 0; j < column; j++)
		{
	         if( i > j)
			       System.out.println("0 ");
	         else
	        	   System.out.println(a[i][j] + " ");
	         }
		System.out.println(); 
		}
	}
}

