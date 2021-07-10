package com.rmg.endToend.scenarios;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.sql.SQLException;
import java.util.List;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import com.rmg.genericcode.com.DataBaseUtiltiles;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PutProject 
{
			@Test
			public void updateAndVerify() throws SQLException
			{
				String status= "completed";
				String actualDatavalue = null;
				
					JSONObject obj=new JSONObject();
					obj.put("created_by", "Shashi");
					obj.put("projectName", "shashi_1909");
					obj.put("status", "completed");
					obj.put("teamSize", 10);
					
					given()
			          .contentType(ContentType.JSON)
			          .body(obj)
			         
					  .when().put("http://localhost:8084/projects/TY_PROJ_404");
					
					Response resp = when().get("http://localhost:8084/projects");
					List<String> list= resp.jsonPath().get("status");
					
					for(String actualData : list )
					{
						System.out.println(actualData);
						if(status.equals(actualData))
						{
							System.out.println(actualData);
							actualDatavalue=actualData;
							break;
						}
					}
					
					DataBaseUtiltiles db = new DataBaseUtiltiles();
					db.connectDB();
					String query = "select * from project;";
					
				     String actualDBvalue = db.executeQuerryAndGetData(query , 5 , status );
					System.out.println(actualDBvalue);
					
					Assert.assertEquals(actualDatavalue,actualDBvalue);
					
			}

}
