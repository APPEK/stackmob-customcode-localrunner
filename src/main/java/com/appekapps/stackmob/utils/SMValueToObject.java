package com.appekapps.stackmob.utils;

import java.util.List;
import java.util.Map;

import com.stackmob.sdkapi.SMCollection;
import com.stackmob.sdkapi.SMList;
import com.stackmob.sdkapi.SMObject;
import com.stackmob.sdkapi.SMPrimitive;
import com.stackmob.sdkapi.SMString;
import com.stackmob.sdkapi.SMValue;

public class SMValueToObject 
{
	public static Object fromSMValue(SMValue<?> smValue)
	{
		if(smValue.isA(SMCollection.class))
		{
			return toCollection(smValue);
		}
		else if(smValue.isA(SMObject.class))
		{
			return toObject(smValue);
		}
		else if(smValue.isA(SMPrimitive.class))
		{
			return toPrimitive(smValue);
		}
		else if(smValue.isA(SMString.class))
		{
			return toString(smValue);
		}
		
		return null;
	}
	
	public static List<? extends SMValue> toCollection(SMValue<?> smValue)
	{
		try
		{
			SMList<? extends SMValue> smList = smValue.asA(SMList.class);
			return smList.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	public static Map<String, ? extends SMValue> toObject(SMValue<?> smValue)
	{
		try
		{
			SMObject smObject = smValue.asA(SMObject.class);
			return smObject.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	public static Object toPrimitive(SMValue<?> smValue)
	{
		return SMPrimitiveToPrimitive.fromSMValue(smValue);
	}
	
	public static String toString(SMValue<?> smValue)
	{
		try
		{
			SMString smString = smValue.asA(SMString.class);
			return smString.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
}
