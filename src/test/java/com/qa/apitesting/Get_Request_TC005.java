package com.qa.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request_TC005 {
	
	@Test
	public void ValidateJSONResponse() {
		
				//Specify base URI
				RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
				
				//Request object 
				RequestSpecification httprequest = RestAssured.given();
				
				//Response Object 
				Response response = httprequest.request(Method.GET,"/Bangalore");
				
				//Print response body in console window 
				String responseBody = response.getBody().asString();
				System.out.println(responseBody);
				Assert.assertEquals(responseBody.contains("Bengaluru"), true);
			
	}

}
