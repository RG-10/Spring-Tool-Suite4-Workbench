package CgpaCalculator;

import java.util.Scanner;
                           //I did complete this program using google :)

public class Cgpa{
	 public static void main(String args[])
	  {
	     @SuppressWarnings("resource")
		Scanner sr = new Scanner(System.in);
	     
	     System.out.println("Please Enter Number of Courses");
	     
	     int n = sr.nextInt();
	     
	     double[] marks = new double[n];
	     
	     System.out.println("Please Enter Marks");
	     
	     for( int i=0; i<n; i++) {
	    	
	    	 marks[i] = sr.nextInt();
	     }
	     
	     @SuppressWarnings("unused")
		double grade[] = new double[n];
	     
	     @SuppressWarnings("unused")
		double cgpa,sum;
	     
	     CGPACalculation s= new CGPACalculation(marks);
	  
	     cgpa=s.getSum()/n;
	  
	     System.out.println("cgpa="+cgpa);
	  
	     System.out.println("percantage from cgpa="+cgpa*9.5);
	  
	    }
	     
}

