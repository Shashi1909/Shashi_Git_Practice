package com.GitParameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameter
{

	@Test
	public void queryParamTest() {
		given()
		   .pathParam("gitUser", "nvnsoni")
		   .queryParam("sort", "created")
		   .auth().oauth2("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")
		.when()
		  .get("https://api.github.com/users/{gitUser}/repos")
		.then()
		  .log().all();
		
	}

}
