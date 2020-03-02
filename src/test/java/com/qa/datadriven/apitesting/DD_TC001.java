package com.qa.datadriven.apitesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DD_TC001 {
	
	@Test(dataProvider="empdataprovider")
	public void postNewEmployee(String ename, String eage, String esal) {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		
		//Created data to send along with post request 
		JSONObject requestparams = new JSONObject();
		requestparams.put("name", ename);
		requestparams.put("salary", eage);
		requestparams.put("age", esal);
		
		//Add a header stating the request body is a JSON 
		httpRequest.header("Content-Type","application/json");
		
		//Add the JSON to the body of request 
		httpRequest.body(requestparams.toJSONString());	
		
		//POST REQUEST 
		Response response = httpRequest.request(Method.POST,"/create");
		
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		//Capture response body to perform validations
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}
	
	@DataProvider(name="empdataprovider")
	public String [][] getEmpData(){
		
		String empdata[][] = {{"abc123","30000","30"},{"pqr123","40000","40"},{"xyz123","50000","50"}};
		return(empdata);
		
	}

}
