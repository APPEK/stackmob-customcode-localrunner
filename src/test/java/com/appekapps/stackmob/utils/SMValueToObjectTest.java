package com.appekapps.stackmob.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.stackmob.sdkapi.SMBoolean;
import com.stackmob.sdkapi.SMList;
import com.stackmob.sdkapi.SMObject;
import com.stackmob.sdkapi.SMString;
import com.stackmob.sdkapi.SMValue;

@SuppressWarnings("rawtypes")
public class SMValueToObjectTest 
{
	@Test
	public void testToCollection()
	{
		List<SMValue<?>> list = new ArrayList<SMValue<?>>();
		SMValue<?> smValue = new SMList<SMValue<?>>(list);
		
		Object listObject = SMValueToObject.fromSMValue(smValue);
		assertEquals(ArrayList.class, listObject.getClass());
	}
	
	@Test
	public void testToObject()
	{
		Map<String, SMValue> map = new HashMap<String,SMValue>();
		SMValue<?> smValue = new SMObject(map);
		
		Object mapObject = SMValueToObject.fromSMValue(smValue);
		assertEquals(HashMap.class, mapObject.getClass());
	}
	
	@Test
	public void testToPrimitive()
	{
		SMValue<?> smValue = new SMBoolean(true);
		
		Object primitiveObject = SMValueToObject.fromSMValue(smValue);
		assertEquals(Boolean.class, primitiveObject.getClass());
	}
	
	@Test
	public void testToSMString()
	{
		SMValue<?> smValue = new SMString("");
		
		Object stringObject = SMValueToObject.fromSMValue(smValue);
		assertEquals(String.class, stringObject.getClass());
	}
}
