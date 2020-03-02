package com.qa.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request_TC006 {
	
	@Test
	public void ExtractValuesJSON() {
		
				//Specify base URI
				RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
				
				//Request object 
				RequestSpecification httprequest = RestAssured.given();
				
				//Response Object 
				Response response = httprequest.request(Method.GET,"/Bangalore");
				
				JsonPath jsonpath = response.jsonPath();
				
				System.out.println(jsonpath.get("City"));
				System.out.println(jsonpath.get("Temperature"));
				System.out.println(jsonpath.get("Humidity"));
				System.out.println(jsonpath.get("WeatherDescription"));
				System.out.println(jsonpath.get("WindSpeed"));
				System.out.println(jsonpath.get("WindDirectionDegree"));
			
	}
	
	

}
