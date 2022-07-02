package com.bs.agent;

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
public class AgentController {

	
	@Autowired
	private AgentHelper helper;
	
	
	
	
	@GetMapping("/AddAgentPage")
	public ModelAndView getAddAgentPage() {
		return new ModelAndView("AddAgentPage", "agentDetail", new AgentDetails());
	}

	@PostMapping("/addAgent")
	public String addAgent(@ModelAttribute AgentDetails patient) {
		AgentDetails savedAgent = helper.addAgent(patient);
		return "redirect:/getAllAgents";
	}

	@GetMapping("/getEditAgentPage/{patientId}")
	public ModelAndView getEditAgentPage(@PathVariable("patientId") Integer patientId) {
//		AgentDetails patientById = service.getAgentById(patientId);
		AgentDetails patientById = helper.getAgentById(patientId);
		return new ModelAndView("UpdateAgentPage", "agentDetail", patientById);
	}

	@PostMapping("/updateAgent")
	public String updateAgent(@ModelAttribute("agentDetail") AgentDetails patient) {
//		service.updateAgent(patient);
		helper.updateAgent(patient);
		return "redirect:/getAllAgents";
	}

	@GetMapping("/deleteAgent/{patientId}")
	public String deleteAgentById(@PathVariable("patientId") Integer patientId) {
//		service.deleteAgentById(patientId);
		helper.deleteAgent(patientId);
		return "redirect:/getAllAgents";
	}

	@GetMapping("/getAllAgents")
	public ModelAndView getAllAgent() {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("patient", service.getAllAgent());
		mav.addObject("agent", helper.getAllAgent());
		mav.setViewName("agentsList");
		return mav;
	}

	public AgentDetails getAgentById(Integer patientId) {
		return helper.getAgentById(patientId);
	}

}
