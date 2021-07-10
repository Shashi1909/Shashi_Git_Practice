package com.responseValidate;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class StaticValidation 
{
		@Test
		public void getAllProjectValidateStaticResponse() {
			String expectedProjectName = "testyantra_Sdet";
	          
	      Response resp = when()                                  
	                       .get("http://localhost:8084/projects");
	      
	      
	      resp.then()                                   
	          .assertThat().statusCode(200)
	          .log().all();
	      
	      String actprojectNAme  = resp.jsonPath().get("[0].projectName");
	      System.out.println("ProjectNAme === > "+actprojectNAme);
	      Assert.assertEquals(expectedProjectName, actprojectNAme);
	          
	          
		}
}
