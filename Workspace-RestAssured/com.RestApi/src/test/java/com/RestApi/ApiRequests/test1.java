package com.RestApi.ApiRequests;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class test1 {

	public static String responseBody;
	public static Response response;

	
	public  static void MoniterProcess (String Action) {
		
		  //Specify base URI
		  
		   
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  
		  
		  requestParams.put("site_id","LAM");
		  requestParams.put("user_id","sduv@codonsoft.com");
		  requestParams.put("entity","customer");
		  requestParams.put("action",Action);
		  requestParams.put("data","{}");
		  
		   System.out.println("request" +  requestParams.toJSONString());
	    	  System.out.println("path : "+System.getProperty("user.dir"));

		  
		 	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MoniterProcess("Hello");
		

	}

}
