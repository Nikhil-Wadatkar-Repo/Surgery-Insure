package com.bs.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PatientController {

	@Autowired
	private PatientService service;

	@GetMapping("/getp")
	public PatientDetails getP() {
		return new PatientDetails();
	}
	@PostMapping("/addPatient")
	public PatientDetails addPatient(@RequestBody PatientDetails patient) {
		PatientDetails savedPatient = service.addPatient(patient);
		return savedPatient ;
	}

	
	@PostMapping("/updatePatient")
	public PatientDetails updatePatient(@RequestBody PatientDetails patient) {
		return service.updatePatient(patient);
	}

	@GetMapping("/deleteemp/{patientId}")
	public String deletePatientById(@PathVariable("patientId") Integer patientId) {
		service.deletePatientById(patientId);
		return service.deletePatientById(patientId);
	}

	@GetMapping("/getAllPatients")
	public List<PatientDetails> getAllPatient() {
		return service.getAllPatient();
	}

	@GetMapping("/getPatientById/{patientId}")
	public PatientDetails getPatientById(@PathVariable("patientId") Integer patientId) {
		return service.getPatientById(patientId);
	}

}
