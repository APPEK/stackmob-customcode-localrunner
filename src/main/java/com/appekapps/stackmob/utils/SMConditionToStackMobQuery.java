package com.appekapps.stackmob.utils;

import java.util.List;

import com.stackmob.sdk.api.StackMobGeoPoint;
import com.stackmob.sdk.api.StackMobQuery;
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
		if(smCondition.getClass().equals(com.stackmob.sdkapi.SMEquals.class))
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
		
		stackMobQuery.fieldIsIn(smIn.getField(), );
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
		stackMobQuery.fieldIsGreaterThan(smGreater.getField(), smGreater.getValue().toString());
	}
	
	private static void addSMGreaterOrEqual(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMGreaterOrEqual smGreaterOrEqual = (SMGreaterOrEqual) smCondition;
		stackMobQuery.fieldIsGreaterThanOrEqualTo(smGreaterOrEqual.getField(), smGreaterOrEqual.getValue().toString());
	}
	
	private static void addSMLess(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMLess smLess = (SMLess) smCondition;
		stackMobQuery.fieldIsLessThan(smLess.getField(), smLess.getValue().toString());
	}
	
	private static void addSMLessOrEqual(StackMobQuery stackMobQuery, SMCondition smCondition)
	{
		SMLessOrEqual smLessOrEqual = (SMLessOrEqual) smCondition;
		stackMobQuery.fieldIslessThanOrEqualTo(smLessOrEqual.getField(), smLessOrEqual.getValue().toString());
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