package com.appekapps.stackmob.utils;

import com.stackmob.sdkapi.SMBoolean;
import com.stackmob.sdkapi.SMPrimitive;

public class SMPrimitiveToPrimitive 
{
	public static SMBoolean toBoolean(SMPrimitive<SMBoolean> smPrimitive)
	{
		try
		{
			if(smPrimitive.isA(SMBoolean.class))
			{
				return smPrimitive.asA(SMBoolean.class);
			}
		}
		catch(Exception e)
		{
			System.out.println(Printer.getStackTraceAsString(e));
		}
		
		return null;
	}
}
