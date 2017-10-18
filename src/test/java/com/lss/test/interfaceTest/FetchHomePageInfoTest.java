package com.lss.test.interfaceTest;

import static io.restassured.RestAssured.given; 

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FetchHomePageInfoTest extends GlobalSessionTest {
	
	@Test
	public void fetchHomePageInfo() { 
		String session = login("xxx", "xx");
		
		Response response =		
		given()
		.log()
		.all()
		.when()
			.header("QUARTZ-SESSION",session)
			.header("SIGN",sign(session)) 
			.post("http://shitouji.bluestonehk.com:6064/fund/base/fetchHomePageInfo")
		.then()
			.statusCode(200) 
			.extract()
			.response();
		
		String result = response.asString();
		System.out.println("--->" + result);
	}
}
