package com.uog.javatpractice;
                                          //In this we observe Java Nested Switch statement.

public class JavaNestedSwitch {

	public static void main(String[] args) {
		                                 //1.Computing - CSE,  2.Engineering- ECE, 3.M- Mechanical  
        char Uni_branch = 'C';                 
        int UsamaUni_Year = 4;  
        switch( UsamaUni_Year )  
        {  
            case 1:  
                System.out.println("English, Maths, Science");  
                break;  
            case 2:  
                switch( Uni_branch )   
                {  
                    case 'C':  
                        System.out.println("Operating System, Java, Data Structure");  
                        break;  
                        
                    case 'E':  
                        System.out.println("Micro processors, Logic switching theory");  
                        break;  
                        
                    case 'M':  
                        System.out.println("Drawing, Manufacturing Machines");  
                        break;  
                }  
                break; 
                
                
            case 3:  
                switch( Uni_branch )   
                {  
                    case 'C':  
                        System.out.println("Computer Organization, MultiMedia");  
                        break;  
                        
                    case 'E':  
                        System.out.println("Fundamentals of Logic Design, Microelectronics");  
                        break;  
                        
                    case 'M':  
                        System.out.println("Internal Combustion Engines, Mechanical Vibration");  
                        break;  
                }  
                break;  
                
            case 4:  
                switch( Uni_branch )   
                {  
                    case 'C':  
                        System.out.println("Data Communication and Networks, MultiMedia");  
                        break;  
                    case 'E':  
                        System.out.println("Embedded System, Image Processing");  
                        break;  
                    case 'M':  
                        System.out.println("Production Technology, Thermal Engineering");  
                        break;  
                }  
                break; 
        }
	}
}
        


