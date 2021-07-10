package com.rmg.CrudTest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class getProjects_BDD 
{

@Test
    
    public void getAllProjectTest()	
    {
    	when()
    	      .get("http://localhost:8084/projects")
    	    .then()
    	    .log().all()
    	    .assertThat().statusCode(200)
    	    .and()
    	    .assertThat().contentType(ContentType.JSON);
    }

	@Test
	public void getAllProject()
	{
	  given()	
		.get("http://localhost:8084/projects")
	    .then()
	    .log().all()
	    .assertThat().statusCode(200)
	    .and()
	    .assertThat().contentType(ContentType.JSON);
		
	}
}
