package com.appekapps.stackmob.example;

import java.util.ArrayList;
import java.util.List;

import com.stackmob.core.customcode.CustomCodeMethod;
import com.stackmob.core.jar.JarEntryObject;

public class EntryPointExtender extends JarEntryObject
{
	@Override
	public List<CustomCodeMethod> methods()
	{
		List<CustomCodeMethod> list = new ArrayList<CustomCodeMethod>();
		
		list.add(new HelloWorld());
		
		return list;
	}
}
