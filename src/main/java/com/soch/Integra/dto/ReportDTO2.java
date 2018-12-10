package com.soch.Integra.dto;

public class ReportDTO2 {
	
	private Integer reportKey;
	
	private String reportKeyString;
	
	private Integer[] count;
	
	private Integer[] dbCount;
	
	private Integer dbReportKey;
	
	private String dbReportKeyString;
	
	private Integer[] techCount;
	
	private Integer techReportKey;
	
	private String techReportKeyString;
	
	private Integer[] ServerCount;
	
	private Integer serverReportKey;
	
	private String serverReportKeyString;
	
	private AppCount appCount;
	
	private AppCount[] appCounts;
	
	private AppDisp[] appDisp;
	
	private AppDisp[] techAppDisp;
	
	public Integer getReportKey() {
		return reportKey;
	}

	public void setReportKey(Integer reportKey) {
		this.reportKey = reportKey;
	}

	public AppCount getAppCount() {
		return appCount;
	}

	public void setAppCount(AppCount appCount) {
		this.appCount = appCount;
	}

	public AppCount[] getAppCounts() {
		return appCounts;
	}

	public void setAppCounts(AppCount[] appCounts) {
		this.appCounts = appCounts;
	}

	public Integer[] getCount() {
		return count;
	}

	public void setCount(Integer[] count) {
		this.count = count;
	}

	public Integer[] getDbCount() {
		return dbCount;
	}

	public void setDbCount(Integer[] dbCount) {
		this.dbCount = dbCount;
	}

	public Integer[] getTechCount() {
		return techCount;
	}

	public void setTechCount(Integer[] techCount) {
		this.techCount = techCount;
	}

	public Integer[] getServerCount() {
		return ServerCount;
	}

	public void setServerCount(Integer[] serverCount) {
		ServerCount = serverCount;
	}

	public Integer getDbReportKey() {
		return dbReportKey;
	}

	public void setDbReportKey(Integer dbReportKey) {
		this.dbReportKey = dbReportKey;
	}

	public Integer    getTechReportKey() {
		return techReportKey;
	}

	public void setTechReportKey(Integer techReportKey) {
		this.techReportKey = techReportKey;
	}

	public Integer getServerReportKey() {
		return serverReportKey;
	}

	public void setServerReportKey(Integer serverReportKey) {
		this.serverReportKey = serverReportKey;
	}

	public AppDisp[] getAppDisp() {
		return appDisp;
	}

	public void setAppDisp(AppDisp[] appDisp) {
		this.appDisp = appDisp;
	}

	public AppDisp[] getTechAppDisp() {
		return techAppDisp;
	}

	public void setTechAppDisp(AppDisp[] techAppDisp) {
		this.techAppDisp = techAppDisp;
	}

	public String getReportKeyString() {
		return reportKeyString;
	}

	public void setReportKeyString(String reportKeyString) {
		this.reportKeyString = reportKeyString;
	}

	public String getDbReportKeyString() {
		return dbReportKeyString;
	}

	public void setDbReportKeyString(String dbReportKeyString) {
		this.dbReportKeyString = dbReportKeyString;
	}

	public String getTechReportKeyString() {
		return techReportKeyString;
	}

	public void setTechReportKeyString(String techReportKeyString) {
		this.techReportKeyString = techReportKeyString;
	}

	public String getServerReportKeyString() {
		return serverReportKeyString;
	}

	public void setServerReportKeyString(String serverReportKeyString) {
		this.serverReportKeyString = serverReportKeyString;
	}
	
	
	
	
	
	
}
