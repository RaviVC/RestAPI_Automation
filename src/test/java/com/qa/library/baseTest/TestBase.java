package com.qa.library.baseTest;

import java.util.logging.Logger;

import org.apache.commons.math3.fraction.ProperBigFractionFormat;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "5138";
	public Logger logger;
	
	@BeforeSuite
	public void setup() {
		Logger.getLogger("EmployeesRestAPI");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	
	
	
	

}
