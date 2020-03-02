package com.qa.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_TC007 {
	
	@Test
	public void AuthorizationTest() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/checkForAuthentication";
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication=authscheme;
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//Status code verification
		int statuscode = response.getStatusCode();
		System.out.println("Status code is"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		
	}

}
