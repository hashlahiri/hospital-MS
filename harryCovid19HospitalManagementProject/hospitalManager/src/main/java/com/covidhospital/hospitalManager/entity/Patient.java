package com.covidhospital.hospitalManager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//The main database table interaction java entity class
//specific table with fields are mentioned with getters and setters and toString method
@Entity
@Table(name="covid_patients")
public class Patient {
	
	//The main id field used in the table
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int p_id;
	
	@Column(name="p_first_name")
	private String firstName;
	
	@Column(name="p_last_name")
	private String lastName;
	
	@Column(name="p_email")
	private String email;
	
	@Column(name="p_entry_date")
	private String entryDate;
	
	@Column(name="p_covid_status")
	private int covidStatus;

	//default constructor
	public Patient() {
		
	}

	//parameterized constructor
	public Patient(int p_id, String firstName, String lastName, String email, String entryDate, int covidStatus) {
		this.p_id = p_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.entryDate = entryDate;
		this.covidStatus = covidStatus;
	}

	//parameterized constructor without id field
	public Patient(String firstName, String lastName, String email, String entryDate, int covidStatus) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.entryDate = entryDate;
		this.covidStatus = covidStatus;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public int getCovidStatus() {
		return covidStatus;
	}

	public void setCovidStatus(int covidStatus) {
		this.covidStatus = covidStatus;
	}

	@Override
	public String toString() {
		return "Patients [p_id=" + p_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", entryDate=" + entryDate + ", covidStatus=" + covidStatus + "]";
	}
	
}