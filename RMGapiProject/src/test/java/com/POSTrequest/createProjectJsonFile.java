package com.POSTrequest;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class createProjectJsonFile 
{

	@Test
	public void createProject() {
	    
		File fileNAme = new File("./PostRmgyantra.json");
		given()
		   .contentType(ContentType.JSON)
		   .body(fileNAme)
		.when()
		   .post("http://localhost:8084/addProject")
		.then()
		   .log().all();
	}
 

}
