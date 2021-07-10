package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class DigestiveAuth 
{
	@Test
		public void degistiveAuth() {
			  //then restAssured provide the credentials before server is asking for it 
			
			given()
			  .auth()
			  .digest("rmgyantra", "rmgy@9999")
		   .when()
		       .get("http://localhost:8084/projects")
	      .then()
	           .log().all();
	          
		}
}
