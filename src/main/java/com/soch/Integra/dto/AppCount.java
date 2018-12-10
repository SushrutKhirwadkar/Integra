package com.soch.Integra.dto;

public class AppCount {
	
	private String officeAcronym;
	
	private String reportKey;
	
	private int appCount = 0;
	
	private String[] appAcronym;

	public String getOfficeAcronym() {
		return officeAcronym;
	}

	public void setOfficeAcronym(String officeAcronym) {
		this.officeAcronym = officeAcronym;
	}

	public String[] getAppAcronym() {
		return appAcronym;
	}

	public void setAppAcronym(String[] appAcronym) {
		this.appAcronym = appAcronym;
	}

	public Integer getAppCount() {
		return appCount;
	}

	public void setAppCount(Integer appCount) {
		this.appCount = appCount;
	}

	public String getReportKey() {
		return reportKey;
	}

	public void setReportKey(String reportKey) {
		this.reportKey = reportKey;
	}
	
	
}
