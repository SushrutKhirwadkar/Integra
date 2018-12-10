package com.soch.Integra.vendors.dto;

import java.util.List;

import com.soch.Integra.vendors.dto.ApplicationSolutionDTO;

public class ReportVendorsDTO implements java.io.Serializable {
	
	List<ApplicationSolutionDTO> appSolutionDTOs;
	String vendorFirstName;
	String vendorLastName;
	String solutionName;
	String vendorName;
	String solutionVersionName;
	int vendorId;
	
	
	
	public List<ApplicationSolutionDTO> getAppSolutionDTOs() {
		return appSolutionDTOs;
	}
	public void setAppSolutionDTOs(List<ApplicationSolutionDTO> appSolutionDTOs) {
		this.appSolutionDTOs = appSolutionDTOs;
	}
	public String getVendorFirstName() {
		return vendorFirstName;
	}
	public void setVendorFirstName(String vendorFirstName) {
		this.vendorFirstName = vendorFirstName;
	}
	public String getVendorLastName() {
		return vendorLastName;
	}
	public void setVendorLastName(String vendorLastName) {
		this.vendorLastName = vendorLastName;
	}
	public String getSolutionName() {
		return solutionName;
	}
	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getSolutionVersionName() {
		return solutionVersionName;
	}
	public void setSolutionVersionName(String solutionVersionName) {
		this.solutionVersionName = solutionVersionName;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	
	
	
	

}
