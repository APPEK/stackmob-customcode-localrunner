package com.appekapps.stackmob.utils;

import java.util.ArrayList;
import java.util.List;

import com.stackmob.sdk.api.StackMobGeoPoint;
import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdkapi.SMCondition;
import com.stackmob.sdkapi.SMEquals;
import com.stackmob.sdkapi.SMGreater;
import com.stackmob.sdkapi.SMGreaterOrEqual;
import com.stackmob.sdkapi.SMIn;
import com.stackmob.sdkapi.SMInt;
import com.stackmob.sdkapi.SMIsNull;
import com.stackmob.sdkapi.SMLess;
import com.stackmob.sdkapi.SMLessOrEqual;
import com.stackmob.sdkapi.SMNear;
import com.stackmob.sdkapi.SMNotEqual;
import com.stackmob.sdkapi.SMString;
import com.stackmob.sdkapi.SMValue;
import com.stackmob.sdkapi.SMWithin;
import com.stackmob.sdkapi.SMWithinBox;

public class SMConditionToStackMobQuery 
{	
	public static StackMobQuery StackMobQuery(String objectName, List<SMCondition> conditions)
	{
		StackMobQuery stackMobQuery = new StackMobQuery();
		stackMobQuery.setObjectName(objectName);
		
		for(SMCondition condition : conditions)
		{
			addSMCondition(stackMobQuery, condition);
		}
		
		return stackMobQuery;
	}
	
	public static void addSMCondition(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		Class clazz = smCondition.getClass();
		if(clazz.equals(com.stackmob.sdkapi.SMIsNull.class))
		{
			addSMIsNull(stackMobQuery, smCondition);
		}
		else if(clazz.equals(com.stackmob.sdkapi.SMIn.class))
		{
			addSMIn(stackMobQuery, smCondition);
		}
		else if(clazz.equals(com.stackmob.sdkapi.SMEquals.class))
		{
			addSMEquals(stackMobQuery, smCondition);
		}
		else if(clazz.equals(com.stackmob.sdkapi.SMNotEqual.class))
		{
			addSMNotEqual(stackMobQuery, smCondition);
		}
		else if(clazz.equals(com.stackmob.sdkapi.SMEquals.class))
		{
			addSMEquals(stackMobQuery, smCondition);
		}
	}
	
	private static void addSMIsNull(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMIsNull smIsNull = (SMIsNull) smCondition;
		
		if(smIsNull.getValue().getValue().booleanValue())
		{
			stackMobQuery.fieldIsNull(smIsNull.getField());
		}
		else
		{
			stackMobQuery.fieldIsNotNull(smIsNull.getField());
		}
	}

	private static void addSMIn(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMIn smIn = (SMIn) smCondition;
		List<? extends SMValue> smValues = smIn.getValues();
		
		List<String> inValues = new ArrayList<String>();		
		for(SMValue<?> smValue : smValues)
		{
			inValues.add(smValue.toString());
		}
		
		stackMobQuery.fieldIsIn(smIn.getField(), inValues);
	}
	
	private static void addSMEquals(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMEquals smEquals = (SMEquals) smCondition;
		stackMobQuery.fieldIsEqualTo(smEquals.getField(), smEquals.getValue().toString());
	}

	private static void addSMNotEqual(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMNotEqual smNotEqual = (SMNotEqual) smCondition;
		stackMobQuery.fieldIsNotEqual(smNotEqual.getField(), smNotEqual.getValue().toString());
	}
	
	private static void addSMGreater(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMGreater smGreater = (SMGreater) smCondition;
		SMValue<?> smValue = smGreater.getValue();
		
		if(smValue.isA(SMInt.class))
		{
			stackMobQuery.fieldIsGreaterThan(smGreater.getField(), SMPrimitiveToPrimitive.toLong(smValue).intValue());
		}
		else if(smValue.isA(SMString.class))
		{
			stackMobQuery.fieldIsGreaterThan(smGreater.getField(), smValue.toString());
		}
	}
	
	private static void addSMGreaterOrEqual(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMGreaterOrEqual smGreaterOrEqual = (SMGreaterOrEqual) smCondition;
		SMValue<?> smValue = smGreaterOrEqual.getValue();
		
		if(smValue.isA(SMInt.class))
		{
			stackMobQuery.fieldIsGreaterThanOrEqualTo(smGreaterOrEqual.getField(), SMPrimitiveToPrimitive.toLong(smValue).intValue());
		}
		else if(smValue.isA(SMString.class))
		{
			stackMobQuery.fieldIsGreaterThanOrEqualTo(smGreaterOrEqual.getField(), smValue.toString());
		}
	}
	
	private static void addSMLess(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMLess smLess = (SMLess) smCondition;
		SMValue<?> smValue = smLess.getValue();
		
		if(smValue.isA(SMInt.class))
		{
			stackMobQuery.fieldIsLessThan(smLess.getField(), SMPrimitiveToPrimitive.toLong(smValue).intValue());
		}
		else
		{
			stackMobQuery.fieldIsLessThan(smLess.getField(), smValue.toString());
		}
	}
	
	private static void addSMLessOrEqual(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMLessOrEqual smLessOrEqual = (SMLessOrEqual) smCondition;
		SMValue<?> smValue = smLessOrEqual.getValue();
		
		if(smValue.isA(SMInt.class))
		{
			stackMobQuery.fieldIsLessThanOrEqualTo(smLessOrEqual.getField(), SMPrimitiveToPrimitive.toLong(smValue).intValue());
		}
		else
		{
			stackMobQuery.fieldIslessThanOrEqualTo(smLessOrEqual.getField(), smValue.toString());
		}
	}
	
	private static void addSMNear(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMNear smNear = (SMNear) smCondition;
		StackMobGeoPoint point = new StackMobGeoPoint(smNear.getLon().getValue(), smNear.getLat().getValue());
		
		stackMobQuery.fieldIsNearWithinKm(smNear.getField(), point, StackMobGeoPoint.radiansToKm(smNear.getDist().getValue()));
	}
	
	private static void addSMWithin(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMWithin smWithin = (SMWithin) smCondition;
		StackMobGeoPoint point = new StackMobGeoPoint(smWithin.getLon().getValue(), smWithin.getLat().getValue());
		
		stackMobQuery.fieldIsWithinRadiusInKm(smWithin.getField(), point, StackMobGeoPoint.radiansToKm(smWithin.getDist().getValue()));
	}
	
	private static void addSMWithinBox(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMWithinBox smWithinBox = (SMWithinBox) smCondition;
		StackMobGeoPoint lowerLeft = new StackMobGeoPoint(smWithinBox.getLonLL().getValue(), smWithinBox.getLatLL().getValue());
		StackMobGeoPoint upperRight = new StackMobGeoPoint(smWithinBox.getLonUR().getValue(), smWithinBox.getLatUR().getValue());
		
		stackMobQuery.fieldIsWithinBox(smWithinBox.getField(), lowerLeft, upperRight);
	}
}