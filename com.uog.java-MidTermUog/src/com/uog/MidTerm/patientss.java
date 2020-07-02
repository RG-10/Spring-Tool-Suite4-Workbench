package com.uog.MidTerm;

public class patientss {
	
		int id;
		
		String name;
		
		int num;
		
		String illness;
		
		public String getIllness() {
		    return illness;
		}

		public void setIllness(String illness) {
		    this.illness = illness;
		}

		public int getNum() {
		    return num;
		}

		public void setNum(int num) {
		    this.num = num;
		}

		public String getName() {
		    return name;
		}

		public void setName(String name) {
		    this.name = name;
		}

		public int getId() {
		    return id;
		}

		public void setId(int id) {
		    this.id = id;
		}
		
		public String toString(){
			
		    return name+" "+id+" "+num+ " "+illness;
		}
	}


