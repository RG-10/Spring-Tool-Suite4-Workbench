package com.uog.java.OuterInnerPrivateClasses;

public class MainClass {

	public static void main(String[] args) {
		OuterClass U1 = new OuterClass();
		OuterClass.InnerClass U2 = U1.new InnerClass();
		System.out.println(U2.y + U1.x);

	}

}
