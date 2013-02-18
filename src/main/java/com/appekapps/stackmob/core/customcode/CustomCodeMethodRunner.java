package com.appekapps.stackmob.core.customcode;

import com.appekapps.stackmob.core.rest.APKProcessedAPIRequest;
import com.appekapps.stackmob.sdkapi.APKSDKServiceProvider;
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
		this.customCodeMethod = customCodeMethod;
	}
		
	public void setCredentials(String username, String password)
	{
		this.serviceProvider = new APKSDKServiceProvider(username, password);
	}
	
	public void setRequest(APKProcessedAPIRequest apkProcessedAPIRequest)
	{
		this.request = apkProcessedAPIRequest;
	}
	
	public ResponseToProcess execute()
	{
		return customCodeMethod.execute(this.request, this.serviceProvider);
	}
}
