package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BasicAuthenticationTest {
  @Test
  public void basicAuthTest()
  {
	  given()
	   .contentType(ContentType.JSON)
	   .auth().basic("rmgyantra","rmgy@9999")
	.when()
	   .post("http://localhost:8084/login")
	.then()
	   .log().all();

  }
}
