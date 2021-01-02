package com.RestApi.ApiRequests;

import org.json.simple.JSONObject;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	public String responseBody;
	public Response response;

	
	public void MoniterProcess (String Action) {
		
		  //Specify base URI
		  RestAssured.baseURI="http://restapi.demoqa.com/customer";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		   
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  
		  
		  requestParams.put("site_id","LAM");
		  requestParams.put("user_id","sduv@codonsoft.com");
		  requestParams.put("entity","customer");
		  requestParams.put("action",Action);
		  requestParams.put("data","{}");
		  
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object
		   response=httpRequest.request(Method.POST,"/monitor");
		   
		   System.out.println("request" +  requestParams.toJSONString());
		    
		  
		  //print response in console window
		  
		   responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
	}
	

}
