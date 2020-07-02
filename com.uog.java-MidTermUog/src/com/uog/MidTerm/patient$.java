package com.uog.MidTerm;
import java.util.ArrayList;
import java.util.Scanner;

public class patient$ {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ArrayList<patientss> patient1= new ArrayList<patientss>();
		 
	     ArrayList<doctorss> doctor1= new ArrayList<doctorss>();
	        
	        Scanner src= new Scanner(System.in);
	        Scanner sc= new Scanner(System.in);
	        Scanner stc= new Scanner(System.in);
	        Scanner sdc= new Scanner(System.in);
	        Scanner update= new Scanner(System.in);
	        Scanner ill=new Scanner(System.in);
	        
	        
	        
	        int id, it, num, i, docid, docit, docnum, docid1;
	        
	        String name, docname, docspecial, illness;
	        
	        int ages, docage;
	        
	        int id1;
	        
	        Boolean leave = false;
	        while(!leave){
	        	
	        	
	            patientss xx= new patientss();
	            System.out.println("Please Enter the patient's ID ");
	            System.out.println("-1 to finish entering");
	            id=src.nextInt();
	            if(id != -1){
	                 xx.setId(id);

	            
	        } 
	            
	            System.out.println("Enter the patient's name ");
	            System.out.println("-1 to finish entering");
	            name=stc.next();
	            if(id != -1){
	                xx.setName(name);
	                patient1.add(xx);
	        } 
	            
	            System.out.println("Enter the patient's Cell phone number");
	            System.out.println("-1 to finish entering");
	            num=sdc.nextInt();
	            if(id != -1){
	                xx.setNum(num);
	                patient1.add(xx);
	        } 
	            
	            System.out.println("Enter the type of illness the patient has!");
	            System.out.println("-1 to finish entering");
	            illness=ill.next();
	            if(id!= -1){
	                xx.setIllness(illness);
	                patient1.add(xx);
	        }

	            else { leave = true; }  // HERE we Escape the while loop.
	        }
	        
	            System.out.println("Enter the id of a patient");
	            it=sc.nextInt();
	            patientss tt= new patientss();
	            for(i=0;i<patient1.size();i++)
	               {
	                    tt=patient1.get(i);
	                    if(it==tt.getId()) 
	            System.out.println(tt.toString());
	                    
	            break;
	        }
	             
	            System.out.println("Please Enter the id of the patient you want to update");
	            
	            Scanner id11= new Scanner(System.in);
	            id1=id11.nextInt();
	            
	            int up, id2;
	            
	            String namess;
	            
	            int phones;
	            
	            patientss dd = new patientss();
	            
	            for(i=0; i<patient1.size(); i++){
	            	
	            dd = patient1.get(i);
	            
	            if(id1==dd.getId()){
	            	
	                System.out.println("If you want to change the name, type 2");
	                System.out.println("If you want to change the number, type 3");
	                System.out.println("If you want to change the id, type 1");
	                
	                up = update.nextInt();
	                
	                if(up==1){
	                    System.out.println("Please Enter a new ID ");
	                    
	                    Scanner idd = new Scanner(System.in);
	                    
	                    id2=idd.nextInt();
	                    dd.setId(id2);
	                    patient1.add(dd);

	            }
	                else if(up==2){
	                	
	                    System.out.println("Please Enter a new name");
	                    
	                    Scanner namme = new Scanner(System.in);
	                    
	                    namess=namme.next();
	                    dd.setName(namess);
	                    patient1.add(dd);

	                }
	                
	                else if(up==3){
	                	
	                    System.out.println("Please Enter a new Cell phone Number");
	                    
	                    Scanner newphone= new Scanner(System.in);
	                    
	                    phones=newphone.nextInt();
	                    dd.setNum(phones);
	                    patient1.add(dd);

	                }
	        }
	            
	            System.out.println(dd);
	            
	            break;
	        } 
	            
	        boolean over = false;
	        
	        while(!over){
	        	
	            doctorss xt= new doctorss();
	            
	            System.out.println("Please Enter the doctor's ID ");
	            System.out.println("-1 to finish entering");
	            
	            docid=src.nextInt();
	            if(docid != -1){
	            	
	                  xt.setDocid(docid);
	            
	            }
	            
	            System.out.println("Please Enter the doctor's name ");
	            System.out.println("-1 to finish entering");
	            
	            docname=stc.next();
	            if(docid != -1){
	            	
	                  xt.setDocname(docname);
	                  doctor1.add(xt);
	            } 
	            
	            System.out.println("Enter the doctor's phone number");
	            System.out.println("-1 to finish entering");
	            
	            docnum=sdc.nextInt();
	            if(docid != -1){
	            	
	                  xt.setDocnum(docnum);
	                  doctor1.add(xt);
	            }
	            
	            System.out.println("What does the doctor specialize in?");
	            
	            String specialize;
	            
	            Scanner special = new Scanner(System.in);
	            
	            specialize = special.next();
	            
	            if(docid != -1){
	            	
	                  xt.setSpecialize(specialize);
	                  doctor1.add(xt);
	            }
	            
	                else { over = true; }//Escape the while loop.
	            
	            }
	        
	            System.out.println("Enter the id of a doctor");
	            docit=sc.nextInt();
	            
	            doctorss tti = new doctorss();
	            
	            for(i=0;i<doctor1.size();i++){
	            	
	               tti = doctor1.get(i);
	                   
	            if(docit == tti.getDocid()) 
	            	
	            System.out.println(tti.toString());
	            }

	   } 
}
