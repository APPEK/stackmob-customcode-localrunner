package com.appekapps.stackmob.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.stackmob.sdkapi.SMBoolean;
import com.stackmob.sdkapi.SMPrimitive;

public class SMPrimitiveToPrimitiveTest 
{
	@Test
	public void testToBoolean()
	{
		SMPrimitive smPrimitive = new SMBoolean(true);
		
		SMBoolean smBoolean = SMPrimitiveToPrimitive.toBoolean(smPrimitive);
		assertEquals(SMBoolean.class, smBoolean.getClass());
	}
}
