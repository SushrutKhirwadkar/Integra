package com.soch.Integra.service;

import java.util.List;

import com.soch.Integra.dto.AssessmentAuditDTO;
import com.soch.Integra.history.dto.AppAuditHistoryDTO;
import com.soch.Integra.history.dto.ApplicationHistoryDTO;

public interface AAMHistoryServices {

	List<ApplicationHistoryDTO> getApplicationHistory(String acronym);
	
	List<AppAuditHistoryDTO> getApplicationAuditHistory(String acronym);

	List<AssessmentAuditDTO> getApplicationAuditHistory(int assessmentId);

}
