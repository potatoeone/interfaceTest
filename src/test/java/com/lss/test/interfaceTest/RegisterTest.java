package com.lss.test.interfaceTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RegisterTest {
	public void register() {
		RegisterParam registerParam = new RegisterParam();
		given()
			.log().all()
			.header("Content-type"," application/json")
			.header("Accept","application/json")//返回的结果的content-type设置为json
			.param("region_code", registerParam.region_code)
			.param("user_name", registerParam.user_name)
			.param("", registerParam.password)
			.param("captcha",registerParam.captcha)
			.param("channel_id", registerParam.channel_id)
		.when()
			.post("http://shitouji.bluestonehk.com/api/user/register")
		.then()
		.statusCode(200);
		
			
	}

}
