package com.lss.test.interfaceTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserRcaptcha {
	public void getcaptcha() {
		GetUserRcaptchaParam param=new GetUserRcaptchaParam();
		
		given()
			.log().all()
			.header("Content-type", " application/json")
			.header("Accept", "application/json")// 返回的结果的content-type设置为json
			.param("user_name", param.user_name)
		    .param("region_code",param.region_code)
		.when()
			.post("http://shitouji.bluestonehk.com/api/user/signup/captcha")
		.then()
			.statusCode(200)
			.body("errno", equalTo(0));		
		
	}
}
