package com.appekapps.stackmob.utils;

import com.stackmob.sdkapi.SMCollection;
import com.stackmob.sdkapi.SMList;
import com.stackmob.sdkapi.SMObject;
import com.stackmob.sdkapi.SMPrimitive;
import com.stackmob.sdkapi.SMString;
import com.stackmob.sdkapi.SMValue;

public class SMValueToObject 
{
	public static SMValue SMValue(SMValue smValue)
	{
		
	}
	
	private static SMString toSMString(SMValue<SMString> smValue)
	{		
		try
		{
			if(smValue.isA(SMString.class))
			{
				return smValue.asA(SMString.class);
			}
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	private static String toString(SMString smString)
	{
		return smString.getValue();
	}
	
	private static SMObject toSMObject(SMValue<SMObject> smValue)
	{		
		try
		{
			if(smValue.isA(SMObject.class))
			{
				return smValue.asA(SMObject.class);
			}
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	private static Map<String,Object> toObject(SMObject smObject)
	{
		// Iterate the map.
		// Reconstruct as Java types.
	}
	
	private static SMPrimitive toSMPrimitive(SMValue<SMPrimitive> smValue)
	{
		try
		{
			if(smValue.isA(SMPrimitive.class))
			{
				return smValue.asA(SMPrimitive.class);
			}
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	private static SMCollection toSMCollection(SMValue<SMCollection> smValue)
	{
		try
		{
			if(smValue.isA(SMCollection.class))
			{
				return smValue.asA(SMCollection.class);
			}
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
	
	private List<Object> toList(SMList<SMValue> smList)
	{
		// Conver to primitive... so much... nesting... need... sleep
	}
	
	private static List<Object> toList(SMCollection smCollection)
	{
		return toList(smCollection.getValue());
	}
}
