package com.covidhospital.hospitalManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidhospital.hospitalManager.dao.PatientRepository;
import com.covidhospital.hospitalManager.entity.Patient;

//the main service layer implements the Patient interface
@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;
	
	//constructor injection used for dependency injection
	@Autowired
	public PatientServiceImpl(PatientRepository thePatientRepository) {
		patientRepository = thePatientRepository;
	}
	
	@Override
	public List<Patient> findAll() {
		
		//returns the list of users after sorting them by their lastnames in ascending order
		//generally used to display the list of patients
		return patientRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Patient findById(int theId) {//getPatientByPatientID()
		
		//optional used to handle crud repository result, may or may not be null
		Optional<Patient> result = patientRepository.findById(theId);
		
		Patient thePatient = null;
		
		//if there is value present then...
		if(result.isPresent()) {
			thePatient=result.get();
		}else {
			//we did not find any patient with given id
			throw new RuntimeException("Did not find patient id: "+theId);
		}
		
		return thePatient;
	}

	@Override
	public boolean save(Patient thePatient) {
		
		//adding new patient into the database table
		thePatient =  patientRepository.save(thePatient);
		
		//if the result output of save is not null that would signify that patient was added into the database
		if(thePatient != null && thePatient.getP_id() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteById(int theId) {
		
		//generally used to grab the id of the patient to be deleted and then deleted
		patientRepository.deleteById(theId);

	}
}
