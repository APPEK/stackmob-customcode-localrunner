package com.appekapps.stackmob.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Printer 
{
	// Writes an Exception as a map.
	public static Map<String,String> getExceptionAsMap(Exception e)
	{
		Map<String,String> exception = new HashMap<String,String>();
		
		exception.put("error", e.getClass().getName());
		exception.put("message", e.getMessage());
		exception.put("stacktrace", getStackTraceAsString(e));
		
		return exception;
	}
	
	// Writes an Exception's StackTrace as a string.
	public static String getStackTraceAsString(Exception e)
	{
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		
		e.printStackTrace(printWriter);
		
		return stringWriter.toString();
	}
}
