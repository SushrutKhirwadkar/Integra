package com.soch.Integra.dto;
// default package
// Generated Sep 13, 2017 3:01:37 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;


public class SubPolicyDTO implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer subPolicyId;
	private String subControlNumber;
	private String subPolicyName;
	private String assignedTo;
	private Date endDate;
	private String subprocedure;
	private String guidelines;
	private String substatus;
	
	
	public Integer getSubPolicyId() {
		return subPolicyId;
	}
	public void setSubPolicyId(Integer subPolicyId) {
		this.subPolicyId = subPolicyId;
	}
	public String getSubControlNumber() {
		return subControlNumber;
	}
	public void setSubControlNumber(String subControlNumber) {
		this.subControlNumber = subControlNumber;
	}
	public String getSubPolicyName() {
		return subPolicyName;
	}
	public void setSubPolicyName(String subPolicyName) {
		this.subPolicyName = subPolicyName;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSubprocedure() {
		return subprocedure;
	}
	public void setSubprocedure(String subprocedure) {
		this.subprocedure = subprocedure;
	}
	public String getGuidelines() {
		return guidelines;
	}
	public void setGuidelines(String guidelines) {
		this.guidelines = guidelines;
	}
	public String getsubstatus() {
		return substatus;
	}
	public void setSubstatus(String substatus) {
		this.substatus = substatus;
	}
	
	
	
	
	
	
	
	
	
	


}


