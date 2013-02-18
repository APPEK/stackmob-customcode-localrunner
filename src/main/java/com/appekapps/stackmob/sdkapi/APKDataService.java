package com.appekapps.stackmob.sdkapi;

import java.net.ConnectException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.appekapps.stackmob.utils.Printer;
import com.appekapps.stackmob.utils.SMConditionToStackMobQuery;
import com.stackmob.core.DatastoreException;
import com.stackmob.core.InvalidSchemaException;
import com.stackmob.sdk.api.StackMob;
import com.stackmob.sdk.api.StackMobDatastore;
import com.stackmob.sdk.callback.StackMobCallback;
import com.stackmob.sdk.exception.StackMobException;
import com.stackmob.sdkapi.BulkResult;
import com.stackmob.sdkapi.DataService;
import com.stackmob.sdkapi.ResultFilters;
import com.stackmob.sdkapi.SMCondition;
import com.stackmob.sdkapi.SMList;
import com.stackmob.sdkapi.SMObject;
import com.stackmob.sdkapi.SMUpdate;
import com.stackmob.sdkapi.SMValue;

public class APKDataService implements DataService 
{
	private final int TIMEOUT = 5000;
	private StackMobDatastore datastore;
	
	public APKDataService(StackMob stackMob)
	{
		this.datastore = stackMob.getDatastore();
	}

	@Override
	public String getUserSchema() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SMObject createObject(String schema, SMObject toCreate)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BulkResult createRelatedObjects(String schema, SMValue objectId,
			String relatedField, List<SMObject> relatedObjectsToCreate)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SMObject> readObjects(String schema, List<SMCondition> conditions) throws InvalidSchemaException, DatastoreException 
	{
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		
		this.datastore.get(SMConditionToStackMobQuery.StackMobQuery(schema, conditions), new StackMobCallback()
		{
			@Override
			public void success(String responseBody)
			{				
				System.out.println(responseBody);
				countDownLatch.countDown();
			}
			
			@Override
			public void failure(StackMobException e)
			{
				System.out.println(Printer.getExceptionAsMap(e));
				countDownLatch.countDown();
			}
		});
		
		try
		{
			countDownLatch.await(TIMEOUT, TimeUnit.MILLISECONDS);			
		}
		catch(Exception e)
		{
			System.out.println(Printer.getExceptionAsMap(e));
		}
		
		return null;
	}

	@Override
	public List<SMObject> readObjects(String schema,
			List<SMCondition> conditions, List<String> fields)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SMObject> readObjects(String schema,
			List<SMCondition> conditions, int expandDepth)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SMObject> readObjects(String schema,
			List<SMCondition> conditions, int expandDepth,
			ResultFilters resultFilters) throws InvalidSchemaException,
			DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SMObject updateObject(String schema, String id,
			List<SMUpdate> updateActions) throws InvalidSchemaException,
			DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SMObject updateObject(String schema, SMValue id,
			List<SMUpdate> updateActions) throws InvalidSchemaException,
			DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SMObject updateObject(String schema, SMValue id,
			List<SMCondition> conditions, List<SMUpdate> updateActions)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateObjects(String schema, List<SMCondition> conditions,
			List<SMUpdate> updateActions) throws InvalidSchemaException,
			DatastoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SMObject addRelatedObjects(String schema, SMValue objectId,
			String relation, List<? extends SMValue> relatedIds)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SMObject addRelatedObjects(String schema, SMValue objectId,
			String relation, SMList relatedIds) throws InvalidSchemaException,
			DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteObject(String schema, String id)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteObject(String schema, SMValue id)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRelatedObjects(String schema, SMValue objectId,
			String relation, List<? extends SMValue> relatedIds,
			boolean cascadeDelete) throws InvalidSchemaException,
			DatastoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRelatedObjects(String schema, SMValue objectId,
			String relation, SMList relatedIds, boolean cascadeDelete)
			throws InvalidSchemaException, DatastoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long countObjects(String schema) throws InvalidSchemaException,
			DatastoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<String> getObjectModelNames() throws ConnectException {
		// TODO Auto-generated method stub
		return null;
	}

}
