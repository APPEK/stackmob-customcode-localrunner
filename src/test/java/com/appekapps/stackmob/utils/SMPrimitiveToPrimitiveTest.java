package com.appekapps.stackmob.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.stackmob.sdkapi.SMBoolean;
import com.stackmob.sdkapi.SMDouble;
import com.stackmob.sdkapi.SMInt;
import com.stackmob.sdkapi.SMPrimitive;
import com.stackmob.sdkapi.SMValue;

public class SMPrimitiveToPrimitiveTest 
{
	@Test
	public void testToBooleanWithSMValue()
	{
		SMValue<?> smValue = new SMBoolean(true);
		
		Object booleanObject = SMPrimitiveToPrimitive.fromSMValue(smValue);
		assertEquals(Boolean.class, booleanObject.getClass());
	}
	
	@Test
	public void testToBooleanWithSMPrimitive()
	{
		SMPrimitive<?> smPrimitive = new SMBoolean(true);
		
		Object booleanObject = SMPrimitiveToPrimitive.fromSMPrimitive(smPrimitive);
		assertEquals(Boolean.class, booleanObject.getClass());
	}
	
	@Test
	public void testToDoubleWithSMValue()
	{
		SMValue<?> smValue = new SMDouble(0.0);
		
		Object doubleObject = SMPrimitiveToPrimitive.fromSMValue(smValue);
		assertEquals(Double.class, doubleObject.getClass());
	}
	
	@Test
	public void testToDoubleWithSMPrimitive()
	{
		SMPrimitive<?> smPrimitive = new SMDouble(0.0);
		
		Object doubleObject = SMPrimitiveToPrimitive.fromSMPrimitive(smPrimitive);
		assertEquals(Double.class, doubleObject.getClass());
	}
	
	@Test
	public void testToLongWithSMValue()
	{
		SMValue<?> smValue = new SMInt(0L);
		
		Object longObject = SMPrimitiveToPrimitive.fromSMValue(smValue);
		assertEquals(Long.class, longObject.getClass());
	}
	
	@Test
	public void testToLongWithSMPrimitive()
	{
		SMPrimitive<?> smPrimitive = new SMInt(0L);
		
		Object longObject = SMPrimitiveToPrimitive.fromSMPrimitive(smPrimitive);
		assertEquals(Long.class, longObject.getClass());
	}
}
