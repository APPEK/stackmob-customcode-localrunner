package com.appekapps.stackmob.sdkapi;

import com.stackmob.core.ServiceNotActivatedException;
import com.stackmob.sdkapi.ConfigVarService;
import com.stackmob.sdkapi.DataService;
import com.stackmob.sdkapi.DatastoreService;
import com.stackmob.sdkapi.FacebookService;
import com.stackmob.sdkapi.LoggerService;
import com.stackmob.sdkapi.PushService;
import com.stackmob.sdkapi.SDKServiceProvider;
import com.stackmob.sdkapi.TwitterService;
import com.stackmob.sdkapi.http.HttpService;

public class APKSDKServiceProvider implements SDKServiceProvider 
{

	@Override
	public LoggerService getLoggerService(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoggerService getLoggerService(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public DatastoreService getDatastoreService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataService getDataService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PushService getPushService() throws ServiceNotActivatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TwitterService getTwitterService()
			throws ServiceNotActivatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacebookService getFacebookService()
			throws ServiceNotActivatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpService getHttpService() throws ServiceNotActivatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfigVarService getConfigVarService()
			throws ServiceNotActivatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSandbox() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

}
