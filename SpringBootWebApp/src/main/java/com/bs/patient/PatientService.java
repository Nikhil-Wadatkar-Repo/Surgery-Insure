package com.bs.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientRepo repo;
	private Optional<PatientDetails> findById;

	public PatientDetails addPatient(PatientDetails patient) {
		PatientDetails savedPatient = repo.save(patient);
		return savedPatient;
	}

	public String deletePatientById(Integer patientId) {
		Optional<PatientDetails> existedPatient = repo.findById(patientId);
		if (existedPatient.isPresent()) {
			repo.deleteById(patientId);
			return "deleted";
		} else {
			return "Not found";
		}
	}

	public PatientDetails updatePatient(PatientDetails patient) {
		Optional<PatientDetails>	findById = repo.findById(patient.getPatientId());
		PatientDetails pat=findById.get();
		pat.setAgentId(patient.getAgentId());
		pat.setSurgeonId(patient.getSurgeonId());
		pat.setPatientcity(patient.getPatientcity());
		pat.setPatientEmailId(patient.getPatientEmailId());
		pat.setPatientFirstName(patient.getPatientFirstName());
		pat.setPatientLastName(patient.getPatientLastName());
		
		return repo.save(pat);
	}

	public List<PatientDetails> getAllPatient() {
		return repo.findAll();
	}

	public PatientDetails getPatientById(Integer patientId) {
		return repo.findById(patientId).get();
	}

}
