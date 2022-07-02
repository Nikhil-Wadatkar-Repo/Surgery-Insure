package com.bs.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientController {

	@Autowired
	private PatientService service;

	@Autowired
	private PatientHelper helper;
	
	@GetMapping("/showDashboard")
	public String getDashboard() {
		return "Dashboard";
	}
	
	@GetMapping("/AddPatientPage")
	public ModelAndView getAddPatientPage() {
		return new ModelAndView("AddPatientPage", "pateintDetail", new PatientDetails());
	}

	@PostMapping("/addPatient")
	public String addPatient(@ModelAttribute PatientDetails patient) {
		PatientDetails savedPatient = helper.addPatient(patient);
		return "redirect:/getAllPatients";
	}

	@GetMapping("/getEditPatientPage/{patientId}")
	public ModelAndView getEditPatientPage(@PathVariable("patientId") Integer patientId) {
//		PatientDetails patientById = service.getPatientById(patientId);
		PatientDetails patientById = helper.getPatientById(patientId);
		return new ModelAndView("UpdatePatientPage", "pateintDetail", patientById);
	}

	@PostMapping("/updatePatient")
	public String updatePatient(@ModelAttribute("pateintDetail") PatientDetails patient) {
//		service.updatePatient(patient);
		helper.updatePatient(patient);
		return "redirect:/getAllPatients";
	}

	@GetMapping("/deleteemp/{patientId}")
	public String deletePatientById(@PathVariable("patientId") Integer patientId) {
//		service.deletePatientById(patientId);
		helper.deletePatient(patientId);
		return "redirect:/getAllPatients";
	}

	@GetMapping("/getAllPatients")
	public ModelAndView getAllPatient() {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("patient", service.getAllPatient());
		mav.addObject("patient", helper.getAllPatient());
		mav.setViewName("patientsList");
		return mav;
	}

	public PatientDetails getPatientById(Integer patientId) {
		return service.getPatientById(patientId);
	}

}
