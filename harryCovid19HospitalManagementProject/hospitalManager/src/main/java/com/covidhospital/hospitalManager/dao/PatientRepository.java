package com.covidhospital.hospitalManager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covidhospital.hospitalManager.entity.Patient;

//used jpa for help related to CRUD operations complexity,reducing boiler plate code
@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{
	
	//adding a method to sort it out by lastName of patients just for convenience
	public List<Patient> findAllByOrderByLastNameAsc();

}