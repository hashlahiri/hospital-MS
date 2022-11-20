package com.covidhospital.hospitalManager.controller;

import java.util.HashMap;
import java.util.List;

//import javax.websocket.server.PathParam;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.covidhospital.hospitalManager.entity.Patient;
import com.covidhospital.hospitalManager.service.PatientService;

//the main restful api annotation implemented here by RestController and mapping for patients created
@RestController
@RequestMapping("/patients")
public class PatientController {

	private PatientService patientService;
	
	//constructor injection used hence autowiring annotation given
	@Autowired
	public PatientController(PatientService thePatientService) {
		patientService = thePatientService;
	}
	
	//the url list under patients created who returns a ResponseEntity
	@GetMapping("/list")
	public ResponseEntity<?> listPatients(Model theModel) {
		
		//get patients from the database
		List<Patient> thePatient = patientService.findAll();
		
		//add to the spring model
		theModel.addAttribute("patient",thePatient);
		
		//use HashMap to map the response status messages
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("status","FAILURE");
		responseMap.put("message","Failed to load..Please try again.");
		
		if(thePatient != null) {
			responseMap.put("status","SUCCESS");
			responseMap.put("message","");
			responseMap.put("patientList",thePatient);
		}
		
		//returns a hashmap as response
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}
	
	//post mapping used for security because of the adding patients procedure
	@PostMapping("/addPatient")
	public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
		//System.out.println("Entered the data");
		//System.out.println(patient.toString());
		
		//save the patient
		boolean addStatus = patientService.save(patient);
		
		//new hashmap created namely responseMap
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("status","FAILURE");
		responseMap.put("message","Failed to load..Please try again.");
		
		if(addStatus) {
			responseMap.put("status","SUCCESS");
			responseMap.put("message","Patient Added successfully..!");
		}
		
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}
	
	//grabbing the id of the patient through request mapping
	@RequestMapping("/getPatientById/{id}")
	public ResponseEntity<?> updatePatient(@PathVariable String id,Model theModel){
		//System.out.println(id);
		//get the patient from the service
		//since the id is string need to convert it into integer hence Integer.parseInt used
		Patient thePatient = patientService.findById(Integer.parseInt(id));
				
		//set patient as a model attribute to prepopulate the form later on
		theModel.addAttribute("patient",thePatient);
		
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("status","FAILURE");
		responseMap.put("message","Failed to load..Please try again.");
		
		//values added as response inside the hashmap and returned
		//ajax displays the content of the map inside the form page
		if(thePatient != null) {
			responseMap.put("status","SUCCESS");
			responseMap.put("message","Patient Updated successfully..!");
			responseMap.put("firstName",thePatient.getFirstName());
			responseMap.put("lastName",thePatient.getLastName());
			responseMap.put("email",thePatient.getEmail());
			responseMap.put("entryDate",thePatient.getEntryDate());
			responseMap.put("covidStatus",thePatient.getCovidStatus());
		}
		
		return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
	
	//request mapping used to grab the id of the patient 
	@RequestMapping("/deletePatientById/{id}")
	public ResponseEntity<?> deletePatientById(@PathVariable String id) {
		
		//deleting the patient through their id
		patientService.deleteById(Integer.parseInt(id));
		
		HashMap<String, Object> responseMap = new HashMap<>();
		responseMap.put("status","FAILURE");
		responseMap.put("message","Failed to load..Please try again.");
		
		if(id != null) {
			responseMap.put("status","SUCCESS");
			responseMap.put("message","Patient Updated successfully..!");
		}
		
		return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
}
