package LabManual_1;
import java.lang.Math;

public class Lab_1 {
       //Task 1
	public static void main(String[] args) {
		System.out.println("HI Computer :)");
		
		//Task 2
		System.out.println("NAME: Usama Raheem Gondal/lived in Los Angeles California");
		
		
		//Task 3 Area of Circle
		double area;
		final double pi = 3.14;
		double radius = 4;
		area = pi*Math.pow(radius,2);
		System.out.println("Area of Circle is :"+area);
		
		//Task4 Find the Volume And Area of a Sphere.
		
		double A_Sphere = 4*pi*Math.pow(radius,2);
		double V_Sphere =(1.33)*pi*Math.pow(radius,2);
		System.out.println("Area of Sphere is :" +A_Sphere+ "Volum of the Sphere is :"+V_Sphere);
		
		//Task 5 Conversion of Celcius to Fehrnhite.
		
		double Temp_C= 33.5;
		double Temp_F=(Temp_C*1.8)+32;
		System.out.println("Tempreture in Fehrnhite is :" +Temp_F);
		
		//Task 6 Multiplying two values.
		
		
		double V1= 34, V2= 45;
		if(V1%2==0) {
			System.out.println(V1+ "is the multiple of" +V2);
		} else {
			System.out.println(V1+ "is not the multiple of "+V2);
		}
		
		//Task 7 Find the largest and Smallest Values in 5 integers.
		
		int arr[]= {1,2,3,4,5};
		int max = arr[0];
		int min = arr[0];
		
		 for(int i= 1;i<=arr.length-1;i++) {
			 if(arr[i]>max)
				 max=arr[i];
			 }
			 
		 
		 
		 for(int j= 1; j<=arr.length-1;j++) {
			 if(arr[j]<min) {
				 min=arr[j];
			 }
		 }
		 System.out.println("Smallest number is :"+min);
		 System.out.println("Largest number is :"+max);
		 
		 //Task 8 
		 //This Particular task is similar to Task 6. so due to lack of self esteem.
		 //RG decided to not do the same thing again and again.
		 //Hope Dr.Nauman will Understand and make this particular descion in consideration.
		 
		 
		 //Task 9, 10 also had similarities to these two also be not get places there. I mean Why not.
			 

		
		
		
		

	}

}
