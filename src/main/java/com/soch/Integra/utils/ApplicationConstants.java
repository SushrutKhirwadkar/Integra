package com.soch.Integra.utils;

public class ApplicationConstants {
	
	public static final String OTHER = "OTHER";
	public static final String RISK_ATTACHMENT = "RISK";
	public static final String AUDIT_ATTACHMENT = "AUDIT";
	public static  final String BUSINESS_ATTACHMENT = "BUSINESS IMPACT";
	public static final String WORKFLOW_ATTACHMENT = "WORKFLOW";
	
	public static final String DATABASE = "DATABASE";
	public static final String APPSERVER = "APPSERVER";
	public static final String TECHNOLOGY = "TECHNOLOGY";
	public static final String OFFICE = "OFFICE";
	
	public static final String ADD_DOCUMENT  = "A";
	public static final String DELETE_DOCUMENT = "D";

	
	
	public static String CREATE_APP_PM_MAIL_SUB = "appname Application Created";
	public static String CREATE_APP_PM_MAIL_BODY = "Dear fName lName, "
			+ "<br> appname has been created and ready for your inputs. You can access the application from APM dashboard.";

	public static final String POLICY_REVIEW_LINK = "/ApplicationPortfolioManager/reviewPolicy.html?a=token";
	public static final String  POLICY_REVIEW_EMAIL_BODY = "Hi,"
			+ "<br> A policy is assigned for review and <a href=\"url\">click here</a> to access the policy.";
	public static String POLICY_REVIEW_EMAIL_SUBJECT = "Policy Assigned for review";
	
}

