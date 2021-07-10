package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class NewAUthTest 
{
  @Test
  public void AuthTest() 
  {
	  Response resp = given()
			  .formParam("client_id", "SDETShashi16")
			  .formParam("client_secret", "49e39d0df377ae1219967203a1031f74")
			  .formParam("grant_type", "client_credentials")
			  .formParam("redirect_uri", "http://shashi1909.com")
			  .when()
			  .post("http://coop.apps.symfonycasts.com/token");
	  
	  String token =  resp.jsonPath().getString("access_token");
	  System.out.println(token);  
	  given()
	   .contentType(ContentType.JSON)
	   .auth().basic("rmgyantra","rmgy@9999")
	   .when()
	   .post("http://coop.apps.symfonycasts.com/api/1997/chickens-feed")
	   .then()
	   .log().all();
  }
}
