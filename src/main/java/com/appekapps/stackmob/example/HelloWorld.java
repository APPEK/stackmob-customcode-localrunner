package com.appekapps.stackmob.example;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.appekapps.stackmob.utils.Printer;
import com.stackmob.core.MethodVerb;
import com.stackmob.core.customcode.CustomCodeMethod;
import com.stackmob.core.rest.ProcessedAPIRequest;
import com.stackmob.core.rest.ResponseToProcess;
import com.stackmob.sdkapi.DataService;
import com.stackmob.sdkapi.SDKServiceProvider;
import com.stackmob.sdkapi.SMCondition;
import com.stackmob.sdkapi.SMEquals;
import com.stackmob.sdkapi.SMString;

public class HelloWorld implements CustomCodeMethod
{
	@Override
	public String getMethodName() 
	{
		return "hello_world";
	}
	
	@Override
	public List<String> getParams() 
	{
		return new ArrayList<String>();
	}
	
	@Override
	public ResponseToProcess execute(ProcessedAPIRequest request, SDKServiceProvider serviceProvider) 
	{   		
		MethodVerb methodVerb = request.getVerb();

		switch(methodVerb)
		{
			case GET:
				return executeGet(request, serviceProvider);
			case POST:
				//return executePost(request, serviceProvider);
			case PUT:
				//return executePut(request, serviceProvider);
			case DELETE:
				//return executeDelete(request, serviceProvider);
			default:
				return new ResponseToProcess(HttpURLConnection.HTTP_NOT_IMPLEMENTED);
		}
	}
	
	public ResponseToProcess executeGet(ProcessedAPIRequest request, SDKServiceProvider serviceProvider)
	{		
		DataService dataService = serviceProvider.getDataService();
		
		Map<String,String> errorMap = new HashMap<String,String>();
		Map<String, Object> responseMap = new HashMap<String, Object>();
		
		try
		{
			List<SMCondition> smConditions = new ArrayList<SMCondition>();
			smConditions.add(new SMEquals("username", new SMString("test")));
			
			dataService.readObjects("users", smConditions);
		}
		catch(Exception e)
		{
			errorMap = Printer.getExceptionAsMap(e);
		}
		
		if(!errorMap.isEmpty())
		{
			return new ResponseToProcess(HttpURLConnection.HTTP_INTERNAL_ERROR, errorMap);
		}
		
		return new ResponseToProcess(HttpURLConnection.HTTP_OK, responseMap);
	}
}
