package com.qa.apitesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest_TC002 {
	
	@Test
	public void RegistrationSuccessful() {
		
		//Specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request payload sending along with post request
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("FirstName", "XYZRavi1");
		requestparams.put("LastName", "XYZVC1");
		requestparams.put("UserName", "XYZRavi1");
		requestparams.put("Password", "XYZRavi");
		requestparams.put("Email", "XYZravivc1971@gmail.com");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparams.toJSONString());
		
		//Response Object
		Response response = httprequest.request(Method.POST,"/register");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//Status code verification
		int statuscode = response.getStatusCode();
		System.out.println("Status code is"+statuscode);
		Assert.assertEquals(statuscode, 201);
		
		//Status line verification 
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		System.out.println("Status line is "+ statusline );
		
		//Successcode validation
		Object successcode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
	}

}
