package com.uog.java.BookPractice;

import java.util.Scanner;

public class Addresses {
	 
	private String name;
	
	private String ct;
	
	private String cu;
	
	private String st;
	
	private String zips;
	
	private String str;
	
	private int n;
	
	private int choice;
	
	private String uname;
	
	private String uct;
	
	private String ucu;
	
	private String ust;
	
	private String uzips;
	
	private String ustr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getCu() {
		return cu;
	}

	public void setCu(String cu) {
		this.cu = cu;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getZips() {
		return zips;
	}

	public void setZips(String zips) {
		this.zips = zips;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUct() {
		return uct;
	}

	public void setUct(String uct) {
		this.uct = uct;
	}

	public String getUcu() {
		return ucu;
	}

	public void setUcu(String ucu) {
		this.ucu = ucu;
	}

	public String getUst() {
		return ust;
	}

	public void setUst(String ust) {
		this.ust = ust;
	}

	public String getUzips() {
		return uzips;
	}

	public void setUzips(String uzips) {
		this.uzips = uzips;
	}

	public String getUstr() {
		return ustr;
	}

	public void setUstr(String ustr) {
		this.ustr = ustr;
	}
	 
	void setdata() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the City Name =");
		ct = sc.next();
		
		System.out.println("Please Enter the Country =");
		cu = sc.next();
		
		System.out.println("Please Enter the State =");
		st = sc.next();
		
		System.out.println("Please Enter the Zip =");
		zips = sc.next();
		
		System.out.println("Please Enter the Name =");
		name = sc.next();
		
		System.out.println("Please Enter the Street =");
		str = sc.next();
	}
	
	void update() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("You have the value of n:");
		n = sc.nextInt();
		
		do {
			System.out.println("Dear You Have Following Choices:");
			
			System.out.println("1 update Name");
			System.out.println("2 update Street");
			System.out.println("3 update City");
			System.out.println("4 update State");
			System.out.println("5 update Country");
			System.out.println("6 update Zips");
			System.out.println("7 Exit");
			
			System.out.println("You have your Choice:");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
			{
				System.out.println(" Update Name=");
				uname = sc.next();
				name = uname;
			}
			break;
			
			case 2:
			{
				System.out.println(" Update Street=");
				ustr = sc.next();
				str = ustr;
			}
			break;
			
			case 3:
			{
				System.out.println(" Update City=");
				uct = sc.next();
				ct = uct;
			}
			break;
			
			case 4:
			{
				System.out.println(" Update State=");
				ust = sc.next();
				st = ust;
			}
			break;
			
			case 5:
			{
				System.out.println(" Update Country=");
				ucu = sc.next();
				cu = ucu;
			}
			break;
			
			case 6:
			{
				System.out.println(" Update Zips=");
				uzips = sc.next();
				zips = uzips;
			}
			break;
			
			default:
				System.out.println(" Invalid Choices=");
			}
			
		} while(n == 7);
	}
	
	void show() {
		
		System.out.println(" The Name =" +name);
		System.out.println(" The Street =" +str);
		System.out.println(" The City =" +ct);
		System.out.println(" The State =" +st);
		System.out.println(" The country =" +cu);
		System.out.println(" The Zip =" +zips);	
	}
}
   
