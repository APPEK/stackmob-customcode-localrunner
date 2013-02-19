package com.appekapps.stackmob.core.customcode;

import java.util.Map;

import com.appekapps.stackmob.core.rest.APKProcessedAPIRequest;
import com.appekapps.stackmob.sdkapi.APKSDKServiceProvider;
import com.stackmob.core.MethodVerb;
import com.stackmob.core.customcode.CustomCodeMethod;
import com.stackmob.core.rest.ResponseToProcess;

public class CustomCodeMethodRunner 
{
	private APKProcessedAPIRequest request;
	private APKSDKServiceProvider serviceProvider;
	
	private CustomCodeMethod customCodeMethod;
	
	public CustomCodeMethodRunner(CustomCodeMethod customCodeMethod)
	{
		this.serviceProvider = new APKSDKServiceProvider();
		this.request = new APKProcessedAPIRequest(this.serviceProvider.getStackMob());
		this.customCodeMethod = customCodeMethod;
		
		this.request.setMethodName(customCodeMethod.getMethodName());
	}
		
	public void setCredentials(String username, String password)
	{
		this.serviceProvider = new APKSDKServiceProvider(username, password);
		this.request = new APKProcessedAPIRequest(this.serviceProvider.getStackMob());
	}
	
	public void setVerb(MethodVerb verb)
	{
		this.request.setVerb(verb);
	}
	
	public void setParams(Map<String,String> params)
	{
		this.request.setParams(params);
	}
	
	public void setBody(String body)
	{
		this.request.setBody(body);
	}
	
	public ResponseToProcess execute()
	{
		return customCodeMethod.execute(this.request.getProcessedAPIRequest(), this.serviceProvider);
	}
}
