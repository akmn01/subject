package com.sitech.prm.subject.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Object[] objs = new Object[] {1,2,3};
		System.out.println(ToStringBuilder.reflectionToString(changeStringArray(objs)));
		System.out.println(ToStringBuilder.reflectionToString(objs));
	}
	
	private Object[] changeStringArray(Object [] arr) {
		Object limitArr[] = {"x","y"};
		arr = combineArray(arr,limitArr);
		return arr;
	}
	
	protected Object[] combineArray(Object[] arr1,Object[] arr2){
    	Object newArray[] = new Object[arr1.length+arr2.length];
    	System.arraycopy(arr1, 0, newArray, 0, arr1.length);  
    	System.arraycopy(arr2, 0, newArray, arr1.length, arr2.length); 
    	return newArray;
    }
	
	@Test
	public void testChange() {
		Object [] sqlParamArrayObjects = getSqlParams().values().toArray(); 
		String [] sqlParamArrayStrings = new String[sqlParamArrayObjects.length];
		//System.arraycopy(sqlParamArrayObjects, 0,sqlParamArrayStrings, 0, sqlParamArrayObjects.length);
		//System.out.println(sqlParamArrayStrings);
		for(int i=0;i<sqlParamArrayObjects.length;i++) {
			sqlParamArrayStrings[i] = ObjectUtils.toString(sqlParamArrayObjects[i]);
			System.out.println(sqlParamArrayStrings[i]);
		}
		
	}
	
	private Map<String,Object> getSqlParams(){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("1", "x");
		params.put("a", 123213);
		return params;
	}
	
	@Test
	public void testPoint() {
		Map<String,Object> params = getSqlParams();
		Map<String,Object> params2 = ObjectUtils.clone(params);
		params2.put("a", 111);
		System.out.println("params:"+params.get("a"));
		System.out.println("params == params2:"+ (params == params2));
	}

}
