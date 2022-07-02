package com.bs.agent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AgentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer agentId;
	@Column
	private Integer surgeonId;

	@Column
	private String agentFirstName;
	@Column
	private String agentLastName;
	@Column
	private String agentEmailId;
	@Column
	private String agentcity;

	public AgentDetails() {
		super();
	}

	public AgentDetails(Integer agentId, Integer surgeonId, String agentFirstName, String agentLastName,
			String agentEmailId, String agentcity) {
		super();
		this.surgeonId = surgeonId;
		this.agentId = agentId;
		this.agentFirstName = agentFirstName;
		this.agentLastName = agentLastName;
		this.agentEmailId = agentEmailId;
		this.agentcity = agentcity;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getSurgeonId() {
		return surgeonId;
	}

	public void setSurgeonId(Integer surgeonId) {
		this.surgeonId = surgeonId;
	}

	public String getAgentFirstName() {
		return agentFirstName;
	}

	public void setAgentFirstName(String agentFirstName) {
		this.agentFirstName = agentFirstName;
	}

	public String getAgentLastName() {
		return agentLastName;
	}

	public void setAgentLastName(String agentLastName) {
		this.agentLastName = agentLastName;
	}

	public String getAgentEmailId() {
		return agentEmailId;
	}

	public void setAgentEmailId(String agentEmailId) {
		this.agentEmailId = agentEmailId;
	}

	public String getAgentcity() {
		return agentcity;
	}

	public void setAgentcity(String agentcity) {
		this.agentcity = agentcity;
	}

	@Override
	public String toString() {
		return "AgentDetails [agentId=" + agentId + ", surgeonId=" + surgeonId + ", agentFirstName=" + agentFirstName
				+ ", agentLastName=" + agentLastName + ", agentEmailId=" + agentEmailId + ", agentcity=" + agentcity
				+ "]";
	}

}
