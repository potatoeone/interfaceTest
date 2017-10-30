package com.lss.test.interfaceTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class FetchRecommendListTest extends GlobalSessionTest{
	
	@Test
	public void fetchRecommendList() {
		given()
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
			.body("errno",equalTo(0));//在json中拿到key为errno的值， 是否与0相等。

		

		//FetchRecommendListParam result = response.as(FetchRecommendListParam.class);
		//断言errno这个字符串是否等于0
		//assertEquals("errno", "0");
		
	
	}
	
}
