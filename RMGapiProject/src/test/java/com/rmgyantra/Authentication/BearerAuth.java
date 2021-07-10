package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearerAuth 
{

	@Test
	public void bearerAuth() {
		  //bearer token Authentication
		
		given()
		  .auth()
		  .oauth2("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")
	   .when()
	       .get("https://api.github.com/users/qspidersseleniumoar/repos")
    .then()
         .log().all();
        
	}
}
