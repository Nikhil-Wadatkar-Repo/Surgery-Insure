package com.bs.agent;

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
public class AgentController {

	@Autowired
	private AgentService service;

	@GetMapping("/getp")
	public AgentDetails getP() {
		return new AgentDetails();
	}
	@PostMapping("/addAgent")
	public AgentDetails addPatient(@RequestBody AgentDetails patient) {
		AgentDetails savedPatient = service.addPatient(patient);
		return savedPatient ;
	}

	
	@PostMapping("/updateAgent")
	public AgentDetails updatePatient(@RequestBody AgentDetails agent) {
		return service.updateAgent(agent);
	}

	@GetMapping("/deleteAgent/{agentId}")
	public String deleteAgentById(@PathVariable("agentId") Integer agentId) {
//		service.deletePatientById(patientId);
		return service.deletePatientById(agentId);
	}

	@GetMapping("/getAllAgents")
	public List<AgentDetails> getAllAgent() {
		return service.getAllAgent();
	}

	@GetMapping("/getAgentById/{agentId}")
	public AgentDetails getAgentById(@PathVariable("agentId") Integer agentId) {
		return service.getAgentById(agentId);
	}

}
