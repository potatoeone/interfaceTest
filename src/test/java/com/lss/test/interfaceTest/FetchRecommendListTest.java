package com.lss.test.interfaceTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.*;
import io.restassured.response.Response;

import static org.hamcrest.Matcher.*;

public class FetchRecommendListTest extends GlobalSessionTest{
	
	@Test
	public void fetchRecommendList() {
		Response response=given()
			.log().all()
			.header("QUARTZ-SESSION",session)
			.header("SIGN",sign(session)) 
			.header("Content-type"," application/json")
			.header("Accept","application/json")//返回的结果的content-type设置为json
		.when()
			.post("http://shitouji.bluestonehk.com:6064/fund/base/fetchRecommendList")
		.then()
			.log().all()
			.statusCode(200)
			.extract()
			.response();
	}
	


}
