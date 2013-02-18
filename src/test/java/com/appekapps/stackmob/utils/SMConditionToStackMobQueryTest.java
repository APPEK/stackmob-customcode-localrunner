package com.appekapps.stackmob.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdkapi.SMBoolean;
import com.stackmob.sdkapi.SMCondition;
import com.stackmob.sdkapi.SMEquals;
import com.stackmob.sdkapi.SMIsNull;
import com.stackmob.sdkapi.SMNotEqual;
import com.stackmob.sdkapi.SMString;

public class SMConditionToStackMobQueryTest 
{
	@Test
	public void testaddSMIsNull()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsNull("test");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMIsNull("test", new SMBoolean(true));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
	
	@Test
	public void testaddSMIsNotNull()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsNotNull("test");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMIsNull("test", new SMBoolean(false));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
	
	/**
	 * @todo addSMIn
	 */
	
	@Test
	public void testaddSMEquals()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsEqualTo("test", "");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMEquals("test", new SMString(""));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
	
	@Test
	public void testaddSMNotEqual()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsNotEqual("test", "");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMNotEqual("test", new SMString(""));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
}
