package com.bs.patient;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bs.agent.AgentDetails;

@Component
public class PatientHelper {

	@Autowired
	public RestTemplate restTemplate;

	public PatientDetails addPatient(PatientDetails patient) {
		PatientDetails createdUser = restTemplate.postForObject("http://localhost:5555/addPatient", patient,
				PatientDetails.class);
		return createdUser;
	}

	public PatientDetails updatePatient(PatientDetails patient) {
		PatientDetails createdUser = restTemplate.postForObject("http://localhost:5555/updatePatient", patient,
				PatientDetails.class);
		return createdUser;
	}

	public String deletePatient(Integer patient) {
		ResponseEntity<Void> exchange = restTemplate.exchange("http://localhost:5555/deleteemp/" + patient,
				HttpMethod.GET, null, Void.class);
		return "Deleted";
	}

	public List<PatientDetails> getAllPatient() {
		ResponseEntity<List<PatientDetails>> responseEntity = restTemplate.exchange(
				"http://localhost:5555/getAllPatients", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PatientDetails>>() {
				});
		return responseEntity.getBody().stream().collect(Collectors.toList());
	}

	public PatientDetails getPatientById(Integer agentId) {
		PatientDetails post = restTemplate.getForObject("http://localhost:5555/getPatientById/" + agentId,
				PatientDetails.class);
		return post;
	}

}
