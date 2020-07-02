package com.uog.MidTerm;

import java.util.Date;

public class Doctor {

	    private int id;
	    
	    private String name;
	    
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}


	class Patient {
		
	    private int id;
	    
	    private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	
	class Illness {
		
	    private int id;
	    
	    private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	

	class Appointment {
		
	    private Doctor doctor;
	    
	    private Patient patient;
	    
	    private Illness illness;
	    
	    private Date date;

	  
		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public Illness getIllness() {
			return illness;
		}

		public void setIllness(Illness illness) {
			this.illness = illness;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}
		  public Appointment(
			      Doctor doctor, Patient patient, Illness illness, Date date )
		  {
			       this.setDoctor(doctor);
			       this.setPatient(patient);
			       this.setIllness(illness);
			       this.setDate(date);
	      }
}


