package com.POSTrequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class createProjectJsonObj 
{
@Test
    
    public void createProject()
    {
	JSONObject jObject= new JSONObject();
	jObject.put("createdBy", "deepak");
	jObject.put("projectName", "zoho-2");
	jObject.put("status", "Created");
	jObject.put("teamSize", 10);
	
	given()
	   .contentType(ContentType.JSON)
	   .body(jObject)
	.when()
	   .post("http://localhost:8084/addProject")
	.then()
	   .log().all()
	   .assertThat().statusCode(201)
	   .assertThat().contentType(ContentType.JSON);
    }

}
