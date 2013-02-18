package com.appekapps.stackmob.utils;

import com.stackmob.sdkapi.SMBoolean;
import com.stackmob.sdkapi.SMDouble;
import com.stackmob.sdkapi.SMInt;
import com.stackmob.sdkapi.SMPrimitive;
import com.stackmob.sdkapi.SMValue;

public class SMPrimitiveToPrimitive 
{
	public static Object fromSMPrimitive(SMPrimitive<?> smPrimitive)
	{
		if(smPrimitive.isA(SMBoolean.class))
		{
			return toBoolean(smPrimitive);
		}
		else if(smPrimitive.isA(SMDouble.class))
		{
			return toDouble(smPrimitive);
		}
		else if(smPrimitive.isA(SMInt.class))
		{
			return toLong(smPrimitive);
		}
		
		return null;
	}
	
	public static Object fromSMValue(SMValue<?> smValue)
	{
		if(smValue.isA(SMBoolean.class))
		{
			return toBoolean(smValue);
		}
		else if(smValue.isA(SMDouble.class))
		{
			return toDouble(smValue);
		}
		else if(smValue.isA(SMInt.class))
		{
			return toLong(smValue);
		}
		
		return null;
	}
	
	public static Boolean toBoolean(SMValue<?> smValue)
	{
		try
		{
			SMBoolean smBoolean = smValue.asA(SMBoolean.class);
			return smBoolean.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	public static Boolean toBoolean(SMPrimitive<?> smPrimitive)
	{
		try
		{
			SMBoolean smBoolean = smPrimitive.asA(SMBoolean.class);
			return smBoolean.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	public static Double toDouble(SMValue<?> smValue)
	{
		try
		{
			SMDouble smDouble = smValue.asA(SMDouble.class);
			return smDouble.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	public static Double toDouble(SMPrimitive<?> smPrimitive)
	{
		try
		{
			SMDouble smDouble = smPrimitive.asA(SMDouble.class);
			return smDouble.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	public static Long toLong(SMValue<?> smValue)
	{
		try
		{
			SMInt smInteger = smValue.asA(SMInt.class);
			return smInteger.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	public static Long toLong(SMPrimitive<?> smPrimitive)
	{
		try
		{
			SMInt smInteger = smPrimitive.asA(SMInt.class);
			return smInteger.getValue();
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
}
