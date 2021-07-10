package com.rmg.genericcode.com;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import com.mysql.cj.jdbc.Driver;

	public class DataBaseUtiltiles 
	{
	   static  Driver driver;
	   static Connection connection;
	   static ResultSet result;
	   
	   public void connectDB()
	   {
		  try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	   }
	   
	   public void closeDB()
	   {
		   try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
	   
	   public ResultSet executeQuery(String query) 
	   {
		   try {
			result=connection.createStatement().executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return result;
	   }
	   
	   public String executeQuerryAndGetData(String query,int columnname, String exceptedData) throws SQLException
	   {
		   boolean flag= false;
		   result = connection.createStatement().executeQuery(query);
		   while(result.next())
		   {
			   if(result.getString(columnname).equals(exceptedData))
			   {
				   flag= true;
				   break;
			   }
			   
			 }
		   if(flag== true)
		   {
			   System.out.println(exceptedData +  "== > data Verfied in database");
			   return exceptedData; 
		   }
		   else
		   {
			   System.out.println(exceptedData + " == > data not verfied in database table");
			   return exceptedData;
		   }
	   }
}
