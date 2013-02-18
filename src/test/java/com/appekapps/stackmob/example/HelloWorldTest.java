package com.appekapps.stackmob.example;

import org.junit.Test;

import com.appekapps.stackmob.core.customcode.CustomCodeMethodRunner;

public class HelloWorldTest 
{
	@Test
	public void testHelloWorld()
	{
		CustomCodeMethodRunner customCodeMethodRunner = new CustomCodeMethodRunner(new HelloWorld());
		customCodeMethodRunner.setCredentials("test", "testing");
		
		customCodeMethodRunner.execute();
	}
}
