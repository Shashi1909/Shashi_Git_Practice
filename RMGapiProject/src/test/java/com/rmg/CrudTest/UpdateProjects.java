package com.rmg.CrudTest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class UpdateProjects 
{

	@Test
	 
	 public void createProject()
	 {
			JSONObject jsonobject = new JSONObject();
	    	jsonobject.put("createBy", "SHASHI");
	    	jsonobject.put("createOn", "jan");
	    	
	    	given()
	    	    .contentType(ContentType.JSON)
	    	    .body(jsonobject.toJSONString())
	    	    .when()
	    	    .patch("http://localhost:8084/projects/TY_PROJ_606")
	    	    .then()
	    	    .log().all();
	 }

}
