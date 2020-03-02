package com.qa.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_TC001 {
	
	@Test
	public void getWeatherDetails() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/Bangalore");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//Status code verification
		int statuscode = response.getStatusCode();
		System.out.println("Status code is"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//Status line verification 
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		System.out.println("Status line is "+ statusline );
		
		
		
	}

}
