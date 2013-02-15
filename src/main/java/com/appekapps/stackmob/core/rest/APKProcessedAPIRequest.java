package com.appekapps.stackmob.core.rest;

import java.util.Map;

import com.stackmob.core.MethodVerb;
import com.stackmob.core.rest.ProcessedAPIRequest;

public class APKProcessedAPIRequest extends ProcessedAPIRequest 
{
	public APKProcessedAPIRequest(MethodVerb verb, String url, String loggedInUser, Map<String, String> params, String appName,	int apiVersion, String methodName, long counter) 
	{
		super(verb, url, loggedInUser, params, appName, apiVersion, methodName, counter);
	}
	
	public APKProcessedAPIRequest(MethodVerb verb, String url, String loggedInUser, Map<String, String> params, String body, String appName, int apiVersion, String methodName, long counter) 
	{
		super(verb, url, loggedInUser, params, appName, body, apiVersion, methodName, counter);
	}
}
