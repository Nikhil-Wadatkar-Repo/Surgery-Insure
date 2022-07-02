package com.bs.patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PatientDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;
	@Column
	private Integer surgeonId;
	@Column
	private Integer agentId;
	@Column
	private String patientFirstName;
	@Column
	private String patientLastName;
	@Column
	private String patientEmailId;
	@Column
	private String patientcity;

	public PatientDetails() {
		super();
	}

	public PatientDetails(Integer patientId, Integer surgeonId, Integer agentId, String patientFirstName,
			String patientLastName, String patientEmailId, String patientcity) {
		super();
		this.patientId = patientId;
		this.surgeonId = surgeonId;
		this.agentId = agentId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientEmailId = patientEmailId;
		this.patientcity = patientcity;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getSurgeonId() {
		return surgeonId;
	}

	public void setSurgeonId(Integer surgeonId) {
		this.surgeonId = surgeonId;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getPatientEmailId() {
		return patientEmailId;
	}

	public void setPatientEmailId(String patientEmailId) {
		this.patientEmailId = patientEmailId;
	}

	public String getPatientcity() {
		return patientcity;
	}

	public void setPatientcity(String patientcity) {
		this.patientcity = patientcity;
	}

	@Override
	public String toString() {
		return "PatientDetails [patientId=" + patientId + ", surgeonId=" + surgeonId + ", agentId=" + agentId
				+ ", patientFirstName=" + patientFirstName + ", patientLastName=" + patientLastName
				+ ", patientEmailId=" + patientEmailId + ", patientcity=" + patientcity + "]";
	}

}
