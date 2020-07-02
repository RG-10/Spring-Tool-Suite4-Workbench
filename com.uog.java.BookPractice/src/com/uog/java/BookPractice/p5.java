package com.uog.java.BookPractice;

import java.util.Scanner;

// Program to check BILLING SYSTEM
public class p5 {
	
	private int billno;
	
	private String cname;
	
	private String itemname;
	
	private int iteamno;
	
	private double qty;
	
	private int n;
	
	private double price;
	
	
	private double amount;

	public int getBillno() {
		return billno;
	}

	public void setBillno(int billno) {
		this.billno = billno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getIteamno() {
		return iteamno;
	}

	public void setIteamno(int iteamno) {
		this.iteamno = iteamno;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
        
	void setdata() {
		
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		System.out.println("Please Enter the Bill Number:");
		billno = s1.nextInt();
		
		System.out.println("Please Enter the CustomerID:");
		cname = s1.next();
		
		System.out.println("Please Enter the Item Number:");
		iteamno = s1.nextInt();
		
		System.out.println("Please Enter the item Name:");
		itemname = s1.next();
		
		System.out.println("Please Enter the item Quantity:");
		qty = s1.nextInt();
		
		System.out.println("Please Enter the item Price:");
		price = s1.nextDouble();
		
		amount = qty * price;
	
	}
	
	void show() {
		
		System.out.println(billno);
		
		System.out.println(cname);
		
		System.out.println(billno);
		
		System.out.println("iteamno  itemname qty price amount");
		
		System.out.println(iteamno +"     " +itemname +"     "+qty+"     "+price+"     "+amount);
		
	}

}

