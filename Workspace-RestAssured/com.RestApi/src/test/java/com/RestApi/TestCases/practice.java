package com.RestApi.TestCases;

import org.testng.annotations.Test;

import com.RestApi.ApiRequests.PostRequest;

public class practice {

	PostRequest pr = new PostRequest();
	@Test
	public void Inventories() {
		pr.MoniterProcess("inventory");
		   pr.response.getStatusCode();
		   
	}
	
	@Test
	public void Customer() {
		pr.MoniterProcess("customer");
		   pr.response.getStatusCode();
		   
	}
	
	@Test
	public void Supplier() {
		pr.MoniterProcess("supplier");
		   pr.response.getStatusCode();
	}
	@Test
	public void Purchaseorder() {
		pr.MoniterProcess("purchaseorder");
		   pr.response.getStatusCode();
	}
	
	@Test
	public void Salesorder() {
		pr.MoniterProcess("salesorder");
		   pr.response.getStatusCode();
		   pr.response.jsonPath().get("");
	}
	
	
}
