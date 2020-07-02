package com.uog.java.practice2;
                            //This program is for polymorphizm. 
                            // Classes includes Human,Babies,OldPeople.and ofcourse the main function.
public class HumanMainClass {

	public static void main(String[] args) {
		Human human1 = new Human();
		Human Babies = new Babies();
		Human OldPeople = new OldPeople();
		
		
		human1.HumanEats();
		Babies.HumanEats();
		OldPeople.HumanEats();
			

	}

}
