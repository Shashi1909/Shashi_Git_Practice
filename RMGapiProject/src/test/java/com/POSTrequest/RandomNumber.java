package com.POSTrequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RandomNumber 
{

	@Test
	public void createProject() {
		
		Random random = new Random();
		int randonInt = random.nextInt(2000);
			
	   /*create an object Project pojo class*/
		PojoClass pojoObj = new PojoClass("deepak", "SBI_"+randonInt, "Completed",10);
		
	
		given()
		  .contentType(ContentType.JSON)
		  .body(pojoObj)
	    .when()
	       .post("http://localhost:8084/addProject")
	    .then()
	      .log().all()
	      .and()
	      .assertThat().statusCode(201);
          
	}

}
