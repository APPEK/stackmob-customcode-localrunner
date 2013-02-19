package com.appekapps.stackmob.sdk.api;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.appekapps.stackmob.utils.Printer;
import com.stackmob.sdk.api.StackMob;
import com.stackmob.sdk.callback.StackMobCallback;
import com.stackmob.sdk.callback.StackMobRedirectedCallback;
import com.stackmob.sdk.exception.StackMobException;

public class APKStackMob 
{
	private static final int TIMEOUT = 5000;
	private static StackMob stackMob;
	
	private static StackMob.OAuthVersion oauthVersion = StackMob.OAuthVersion.Two;
	private static Integer apiVersionNumber = new Integer(0);	
	private static String apiKey = "dcc693b3-b56e-4bf2-8272-bd53176a30ae";
	private static String apiSecret = "5b5cf752-848a-4906-accb-154e96e67ff8";
	private static String apiHost = StackMob.DEFAULT_API_HOST;
	private static String userSchema = StackMob.DEFAULT_USER_SCHEMA_NAME;
	private static String userIdName = StackMob.DEFAULT_USER_ID;
	private static String passwordFieldName = StackMob.DEFAULT_PASSWORD_FIELD;
	private static StackMobRedirectedCallback redirectedCallback = StackMob.DEFAULT_REDIRECTED_CALLBACK;
	
	public static StackMob getStackMob()
	{
		return new StackMob(oauthVersion, apiVersionNumber, apiKey, apiSecret, apiHost, userSchema, userIdName, passwordFieldName, redirectedCallback);
	}
	
	public static StackMob getStackMobWithCredentials(String username, String password)
	{
		final CountDownLatch countDownLatch = new CountDownLatch(1);

		Map<String,String> params = new HashMap<String,String>();
		params.put(APKStackMob.userIdName, username);
		params.put(APKStackMob.passwordFieldName, password);
		
		APKStackMob.stackMob = APKStackMob.getStackMob();		
		APKStackMob.stackMob.login(params, new StackMobCallback()
		{
			@Override
			public void success(String responseBody)
			{
				System.out.println(responseBody);
				countDownLatch.countDown();
			}
			
			@Override
			public void failure(StackMobException e)
			{
				System.out.println(Printer.getStackTraceAsString(e));
				countDownLatch.countDown();
			}
		});
		
		try 
		{
			countDownLatch.await(APKStackMob.TIMEOUT, TimeUnit.MILLISECONDS);
		} 
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return APKStackMob.stackMob;
	}
}
