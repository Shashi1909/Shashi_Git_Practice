package com.rmg.CrudTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectsBDD
{

@Test
    
    public void createProjectsTest()
    {
    	JSONObject jsonobject = new JSONObject();
    	jsonobject.put("createBy", "Deepak");
    	jsonobject.put("createOn", "jan");
    	jsonobject.put("projectName", "Yes");
    	jsonobject.put("status", "Completed");
    	
    	given()
    	      .contentType(ContentType.JSON)
    	      .body(jsonobject.toJSONString())
    	      .when()
    	      .post("http://localhost:8084/addProject")
    	      .then()
    	      .log().all();
    	  
    	
    }
}
