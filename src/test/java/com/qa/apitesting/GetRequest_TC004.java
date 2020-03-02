package com.qa.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_TC004 {
	
	@Test
	public void printAllHeaders() {
		
				//Specify base URI
				RestAssured.baseURI = "https://maps.googleapis.com";
				
				//Request object 
				RequestSpecification httprequest = RestAssured.given();
				
				//Response Object 
				Response response = httprequest.request(Method.GET,"//maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
				
				//Print response body in console window 
				String responseBody = response.getBody().asString();
				System.out.println(responseBody);
				
				//Capture all headers
				Headers allHeaders = response.headers();
				System.out.println(allHeaders);
				
				for(Header header:allHeaders) {
					System.out.println(header.getName()+"       "+header.getValue());
				}
		
	}

}
