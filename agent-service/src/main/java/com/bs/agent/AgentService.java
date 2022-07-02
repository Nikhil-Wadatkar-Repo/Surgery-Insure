package com.bs.agent;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

	@Autowired
	private AgentRepo repo;

	public AgentDetails addPatient(AgentDetails agent) {
		AgentDetails savedPatient = repo.save(agent);
		return savedPatient;
	}

	public String deletePatientById(Integer agentId) {
		Optional<AgentDetails> existedPatient = repo.findById(agentId);
		if (existedPatient.isPresent()) {
			repo.deleteById(agentId);
			return "deleted";
		} else {
			return "Not found";
		}
	}

	public AgentDetails updateAgent(AgentDetails agent) {
		Optional<AgentDetails>	findById = repo.findById(agent.getAgentId());
		AgentDetails pat=findById.get();
		pat.setAgentId(agent.getAgentId());
		pat.setSurgeonId(agent.getSurgeonId());
		pat.setAgentcity(agent.getAgentcity());
		pat.setAgentEmailId(agent.getAgentEmailId());
		pat.setAgentFirstName(agent.getAgentFirstName());
		pat.setAgentLastName(agent.getAgentLastName());
		
		return repo.save(pat);
	}

	public List<AgentDetails> getAllAgent() {
		return repo.findAll();
	}

	public AgentDetails getAgentById(Integer agentId) {
		return repo.findById(agentId).get();
	}

}
