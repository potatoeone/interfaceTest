package com.lss.test.interfaceTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.commons.beanutils.BeanUtils;

public class GetUserRcaptcha {
	public static void getcaptcha(String phone) {
		GetUserRcaptchaParam param=new GetUserRcaptchaParam();
		param.user_name = phone;
		param.region_code="86";
		String asString = given()
			.log().all()
			//.header("Content-type", " application/json")
			.header("Accept", "application/json")// 返回的结果的content-type设置为json
			.param("user_name", param.user_name)
		    .param("region_code",param.region_code)
		.when()
			.post("http://shitouji.bluestonehk.com/api/user/signup/captcha").asString();
		System.out.println( asString);
		
	}
}
