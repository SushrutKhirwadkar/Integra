package com.soch.Integra.dto;

import java.util.List;

public class ALLReportDTO {
	
	private List<ReportDTO2> dbReport;
	
	private List<ReportDTO2> techReport;
	
	private List<ReportDTO2> appServerReport;

	public List<ReportDTO2> getDbReport() {
		return dbReport;
	}

	public void setDbReport(List<ReportDTO2> dbReport) {
		this.dbReport = dbReport;
	}

	public List<ReportDTO2> getTechReport() {
		return techReport;
	}

	public void setTechReport(List<ReportDTO2> techReport) {
		this.techReport = techReport;
	}

	public List<ReportDTO2> getAppServerReport() {
		return appServerReport;
	}

	public void setAppServerReport(List<ReportDTO2> appServerReport) {
		this.appServerReport = appServerReport;
	}
	
	

}
