package com.qa.restapi.automation.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.library.baseTest.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetRequest_AllEmployees_TC001 extends TestBase {

	@BeforeClass
	public void getAllEmployees() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employees");
	}

	@Test
	public void checkResponseBody() {
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
	}
	
	@Test
	public void checkStatusCode() {
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
	}
	
	@Test
	public void checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
	}
	
	@Test
	public void checkContentType() {
		String contentType = response.contentType();
		System.out.println(contentType);
	}
	
	@Test
	public void checkSessionID() {
		String SessionID = response.getSessionId();
		System.out.println(SessionID);
	}
	
	@Test
	public void checkCookies() {
		String Cookies = response.getCookie("PHPSESSID");
		System.out.println(Cookies);
	}
	
	@Test
	public void checkContentLength() {
		String contentLength = response.header("Content-Length");
		if(Integer.parseInt(contentLength)<100) {
			Assert.assertTrue(Integer.parseInt(contentLength)>100);
		}
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("Test Case Execution Completed - GetRequest_AllEmployees_TC001");
	}
	
}
