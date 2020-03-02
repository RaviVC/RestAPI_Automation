package com.qa.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request_TC003 {
	
	@Test
	public void GoogleMapTest() {
		
		//Specify base URI
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Request object 
		RequestSpecification httprequest = RestAssured.given();
		
		//Response Object 
		Response response = httprequest.request(Method.GET,"//maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Print response body in console window 
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//Validating headers 
		//Capture details of headers from response 
		String contentType = response.header("Content-Type");
		System.out.println("Content Type is:" + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
		
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("Content Type is:" + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		
	}

}
