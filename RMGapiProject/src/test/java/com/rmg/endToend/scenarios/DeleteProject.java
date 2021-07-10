package com.rmg.endToend.scenarios;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.sql.SQLException;
import java.util.List;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmg.genericcode.com.DataBaseUtiltiles;

public class DeleteProject 
{
			@Test
			public void deleteAndVerify() throws SQLException
			{
				String project_name= "shashi_sdet16_project";
				String actualDatavalue = null;
				
					/*JSONObject obj=new JSONObject();
					obj.put("createby", "Shashi");
					obj.put("projectName", "raja_sdet16_project");
					obj.put("status", "Running");
					obj.put("teamSize", 10);
					
					given()
			          .contentType(ContentType.JSON)
			          .body(obj)*/
			         
					  when().delete("http://localhost:8084/projects/TY_PROJ_1803");
					
					Response resp = when().get("http://localhost:8084/projects");
					List<String> list= resp.jsonPath().get("projectName");
					
					for(String actualData : list )
					{
						System.out.println(actualData);
						if(project_name.equals(actualData))
						{
							System.out.println(actualData);
							actualDatavalue=actualData;
							break;
						}
					}
					
					DataBaseUtiltiles db = new DataBaseUtiltiles();
					db.connectDB();
					String query = "select * from project;";
					
				     String actualDBvalue = db.executeQuerryAndGetData(query , 4 , project_name );
					System.out.println(actualDBvalue);
					
					Assert.assertEquals(actualDatavalue,actualDBvalue);
					
			}

}
