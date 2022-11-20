package com.covidhospital.hospitalManager.service;

import java.util.List;

import com.covidhospital.hospitalManager.entity.Patient;

//the overall services architecture for the application
public interface PatientService {

	//to list all patients
	public List<Patient> findAll();
	
	//to find the patients by their id
	public Patient findById(int theId);
	
	//to save the patients
	public boolean save(Patient thePatient);
	
	//to delete the patients by their id
	public void deleteById(int theId);
	
}
