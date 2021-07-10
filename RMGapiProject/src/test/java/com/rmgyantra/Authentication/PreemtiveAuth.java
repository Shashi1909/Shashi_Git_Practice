package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PreemtiveAuth 
{

	@Test
		public void PreemtivAuth() {
		//server should ask for credentials , then restAssured provide the data
			
			given()
			  .auth()
			  .preemptive().basic("rmgyantra", "rmgy@9999")
		   .when()
		       .get("http://localhost:8084/projects")
	      .then()
	           .log().all();
	          
		}
}
