package com.lss.test.interfaceTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import static org.testng.Assert.assertEquals;
//import com.google.gson.Gson;


import io.restassured.response.Response;
/****
 * 
 * @author liangshishi
 * @category取基金首页信息
 *
 */

public class FetchHomePageInfoTest extends GlobalSessionTest {
	
	@Test
	public void fetchHomePageInfo() { 
			
		Response response=	
		given()
			.log().all()
			.header("QUARTZ-SESSION",session)
			.header("SIGN",sign(session)) 
			.header("Content-type"," application/json")
			.header("Accept","application/json")//返回的结果的content-type设置为json
		.when()			
			.post("http://shitouji.bluestonehk.com:6064/fund/base/fetchHomePageInfo")
		.then()
			.log().all()
			.statusCode(200)
			.extract()
			.response();
		
//		//讲结果已string类型保存到s中
//		String s = response.asString();
//		//实例化一个Gson对象，用来将字符串类型转换为Json格式
//		Gson gson = new Gson();
//		//将返回结果转换为json格式，之后在以类名.字段的方式取值，存到result中
//		BaselResult result = gson.fromJson(s, BaselResult.class);
		
		FetchHomePageInfoParams result = response.as(FetchHomePageInfoParams.class);
		
		
		Assert.assertEquals(result.errno, 0);
		assertEquals(result.message, "请求成功");
		
		

	}
}
