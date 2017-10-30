package com.lss.test.interfaceTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.annotations.Test;

public class FetchUserPositionListTest extends GlobalSessionTest {
	
	@Test
	public void fetchUserPositionList() {
		given()
			.log().all()
			.header("QUARTZ-SESSION",session)
			.header("SIGN",sign())
			.header("Content-type"," application/json")
			.header("Accept","application/json")//返回的结果的content-type设置为json
			
		.when()
			.post("http://shitouji.bluestonehk.com:6064/fund/position/fetchUserPositionList")
			
		.then()
			.log().all()
			.statusCode(200);
		
			
	}
	

}
