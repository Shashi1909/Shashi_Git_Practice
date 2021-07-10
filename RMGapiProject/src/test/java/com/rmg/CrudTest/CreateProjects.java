package com.rmg.CrudTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CreateProjects 
{
	  @Test
	    public void createProjects()
	    {
	    	JSONObject jsonobject = new JSONObject();
	    	jsonobject.put("createBy", "Deepak1");
	    	jsonobject.put("createOn", "jan");
	    	jsonobject.put("projectName", "YESYES");
	    	jsonobject.put("status", "Completed");
	    	
	    	RequestSpecification req = RestAssured.given();
	    	req.contentType(ContentType.JSON);
	    	req.body(jsonobject);
	    	
	    	
	    }
}
