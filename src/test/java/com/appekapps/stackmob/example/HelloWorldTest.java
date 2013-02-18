package com.appekapps.stackmob.example;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.appekapps.stackmob.core.customcode.CustomCodeMethodRunner;

public class HelloWorldTest 
{
	@Test
	public void testHelloWorld()
	{
		CustomCodeMethodRunner customCodeMethodRunner = new CustomCodeMethodRunner(new HelloWorld());
		Map<String,String> params = new HashMap<String,String>();
		String body = "";
		
		//customCodeMethodRunner.setParams(params);
		//customCodeMethodRunner.setBody(body);
		customCodeMethodRunner.setCredentials("test", "testing");
		
		customCodeMethodRunner.execute();
	}
}
