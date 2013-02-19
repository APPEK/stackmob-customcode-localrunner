package com.appekapps.stackmob.core.rest;

import java.util.Map;

import com.stackmob.core.MethodVerb;
import com.stackmob.core.rest.ProcessedAPIRequest;
import com.stackmob.sdk.api.StackMob;

public class APKProcessedAPIRequest
{	
	private MethodVerb verb;
	private String url; //StackMob.DEFAULT_API_HOST + appName?
	private String loggedInUser;
	private Map<String,String> params;
	private String body;
	private String appName;
	private int apiVersion;
	private String methodName;
	private long counter;
	
	public APKProcessedAPIRequest(StackMob stackMob)
	{		
		this.loggedInUser = stackMob.getLoggedInUsername();
		//this.appName = 
		this.apiVersion = stackMob.getSession().getApiVersionNumber();
		//this.counter = 
	}
	
	public void setVerb(MethodVerb verb)
	{
		this.verb = verb;
	}
	
	public void setParams(Map<String,String> params)
	{
		this.params = params;
	}
	
	public void setBody(String body)
	{
		this.body = body;
	}
	
	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}
	
	public ProcessedAPIRequest getProcessedAPIRequest()
	{
		if(this.body == null || this.body.equals(""))
		{
			return new ProcessedAPIRequest(this.verb, this.url, this.loggedInUser, this.params, this.appName, this.apiVersion, this.methodName, this.counter);
		}
		else
		{
			return new ProcessedAPIRequest(this.verb, this.url, this.loggedInUser, this.params, this.body, this.appName, this.apiVersion, this.methodName, this.counter);
		}
	}
}
