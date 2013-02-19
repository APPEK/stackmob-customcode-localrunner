package com.appekapps.stackmob.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.stackmob.sdk.api.StackMobGeoPoint;
import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdkapi.SMBoolean;
import com.stackmob.sdkapi.SMCondition;
import com.stackmob.sdkapi.SMEquals;
import com.stackmob.sdkapi.SMGreater;
import com.stackmob.sdkapi.SMGreaterOrEqual;
import com.stackmob.sdkapi.SMIn;
import com.stackmob.sdkapi.SMIsNull;
import com.stackmob.sdkapi.SMLess;
import com.stackmob.sdkapi.SMLessOrEqual;
import com.stackmob.sdkapi.SMNear;
import com.stackmob.sdkapi.SMNotEqual;
import com.stackmob.sdkapi.SMString;
import com.stackmob.sdkapi.SMWithin;
import com.stackmob.sdkapi.SMWithinBox;

public class SMConditionToStackMobQueryTest 
{
	@Test
	public void testAddSMIsNull()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsNull("test");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMIsNull("test", new SMBoolean(true));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
	
	@Test
	public void testAddSMIsNotNull()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsNotNull("test");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMIsNull("test", new SMBoolean(false));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
	
	@Test
	public void testAddSMIn()
	{
		List<String> stackMobQueryValues = new ArrayList<String>();
		stackMobQueryValues.add("");
		
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsIn("test", stackMobQueryValues);
		
		List<SMString> smConditionValues = new ArrayList<SMString>();
		smConditionValues.add(new SMString(""));
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMIn("test", smConditionValues);
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
	
	@Test
	public void testAddSMEquals()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsEqualTo("test", "");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMEquals("test", new SMString(""));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
	
	@Test 
	public void testAddSMNotEqual()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsNotEqual("test", "");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMNotEqual("test", new SMString(""));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());		
	}
	
	@Test
	public void testAddSMGreater()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsGreaterThan("test", "");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMGreater("test", new SMString(""));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());	
	}
	
	@Test
	public void testAddSMGreaterOrEqual()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsGreaterThanOrEqualTo("test", "");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMGreaterOrEqual("test", new SMString(""));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());	
	}
	
	@Test
	public void testAddSMLess()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIsLessThan("test", "");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMLess("test", new SMString(""));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());	
	}
	
	@Test
	public void testAddSMLessOrEqual()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.fieldIslessThanOrEqualTo("test", "");
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMLessOrEqual("test", new SMString(""));
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());	
	}
	
	@Test
	public void testAddSMNear()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		StackMobGeoPoint point = new StackMobGeoPoint(new Double(0), new Double(0));
		stackMobQuery.fieldIsNear("test", point);
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMNear("test", 0, 0, 0);
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());	
	}
	
	@Test
	public void testAddSMWithin()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		StackMobGeoPoint point = new StackMobGeoPoint(new Double(0), new Double(0));
		stackMobQuery.fieldIsWithinRadiusInKm("test", point, StackMobGeoPoint.radiansToKm(0));
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMWithin("test", 0, 0, 0);
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());	
	}
	
	@Test
	public void testAddSMWithinBox()
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		StackMobGeoPoint lowerLeft = new StackMobGeoPoint(new Double(0), new Double(0));
		StackMobGeoPoint upperRight = new StackMobGeoPoint(new Double(0), new Double(0));
		stackMobQuery.fieldIsWithinBox("test", lowerLeft, upperRight);
		
		StackMobQuery smConditionQuery = new StackMobQuery();
		SMCondition smCondition = new SMWithinBox("test", 0, 0, 0, 0);
		SMConditionToStackMobQuery.addSMCondition(smConditionQuery, smCondition);
		
		assertEquals(stackMobQuery.getArguments(), smConditionQuery.getArguments());	
	}
}
