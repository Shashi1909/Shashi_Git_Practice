package com.responseValidate;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidation 
{
	@Test
	public void getAllProjectAndValidateDynamicResponse() {
		String expectedProjectName = "APITEST";
        boolean flag = false;  
      Response resp = when()                                  
                       .get("http://localhost:8084/projects");
      
      
      resp.then()                                   
          .assertThat().statusCode(200)
          .log().all();
      
      List<String> list  = resp.jsonPath().get("projectName");
     
       
      for(String str : list) {
    	  if(expectedProjectName.equals(str)) {
    		  System.out.println(expectedProjectName + "==>available==PASS");
    		  flag = true;
    		  break;
    	  }
      }
          
          Assert.assertEquals(flag, true);
          System.out.println(list.size());
	}
	
}
