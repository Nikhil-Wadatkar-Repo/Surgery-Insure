package com.bs.agent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends JpaRepository<AgentDetails, Integer> {

//	@Modifying
//	@Query("update Patient_Details set AGENT_ID=?1where PATIENT_ID=?2;")
//	PatientDetails updatePhone(@Param(value = "AGENT_ID") Integer AGENT_ID, @Param(value = "SURGEON_ID") Integer SURGEON_ID,
//			@Param(value = "PATIENT_FIRST_NAME") String PATIENT_FIRST_NAME,
//			@Param(value = "PATIENT_LAST_NAME") String PATIENT_LAST_NAME,
//			@Param(value = "PATIENT_EMAIL_ID") String PATIENT_EMAIL_ID,
//			@Param(value = "PATIENTCITY") String PATIENTCITY, @Param(value = "PATIENT_ID") Integer PATIENT_ID);


}
