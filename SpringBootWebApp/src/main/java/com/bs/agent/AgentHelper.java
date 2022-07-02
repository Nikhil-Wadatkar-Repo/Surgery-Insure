package com.bs.agent;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bs.patient.PatientDetails;

@Component
public class AgentHelper {

	@Autowired
	public RestTemplate restTemplate;

	public AgentDetails addAgent(AgentDetails agent) {
		AgentDetails createdUser = restTemplate.postForObject("http://localhost:6666/addAgent", agent,
				AgentDetails.class);
		return createdUser;
	}

	public AgentDetails updateAgent(AgentDetails agent) {
		AgentDetails createdUser = restTemplate.postForObject("http://localhost:6666/updateAgent", agent,
				AgentDetails.class);
		return createdUser;
	}

	public String deleteAgent(Integer agent) {
		String url = "https://jsonplaceholder.typicode.com/posts/1";
		ResponseEntity<Void> exchange = restTemplate.exchange("http://localhost:6666/deleteAgent/" + agent,
				HttpMethod.GET, null, Void.class);
		return "Deleted";
	}

	public List<AgentDetails> getAllAgent() {
		ResponseEntity<List<AgentDetails>> responseEntity = restTemplate.exchange("http://localhost:6666/getAllAgents",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<AgentDetails>>() {
				});
		return responseEntity.getBody().stream().collect(Collectors.toList());
	}

	public AgentDetails getAgentById(Integer agentId) {
		AgentDetails post = restTemplate.getForObject("http://localhost:6666/getAgentById/" + agentId,
				AgentDetails.class);
		return post;
	}

}
