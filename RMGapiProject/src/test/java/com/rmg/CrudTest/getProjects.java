package com.rmg.CrudTest;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getProjects 
{
	@Test
	public void getProject()
	{
		Response rsp = RestAssured.get("http://localhost:8084/projects");
		
		//rsp.prettyPrint();
	    ValidatableResponse resVal = rsp.then();
	    System.out.println(resVal.log().all());
		
	}
}
