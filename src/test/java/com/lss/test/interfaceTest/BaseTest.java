package com.lss.test.interfaceTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {

	@BeforeClass
	public void before() {
		RestAssured.baseURI = "http://shitouji.bluestonehk.com";
		given().log().all();
	}

	public String login(String username,String password,String region_code) {
		// 对密码进行加密
		String md5Pwd = DigestUtils.md5Hex(password);
		LoginParams loginparam = new LoginParams();
		loginparam.password = md5Pwd;
		loginparam.user_name = username;
		loginparam.region_code = region_code;

		Response response = given().log()
			.all().
				formParam("password", loginparam.password)
				.formParam("region_code", loginparam.region_code)
				.formParam("user_name", loginparam.user_name)
			.when()
				.post("/api/app/user/login").then().log().all().statusCode(200).body("errno", equalTo(0))
				.body("body.phone", equalTo(loginparam.user_name))
				.body("body.region_code", equalTo(loginparam.region_code))
				.body("message", equalTo("登录成功"))
			.extract().response();
		// 保存
		return response.path("body.session");
	}
	
	
	public String sign(Object params,String session) {
		return SignUtils.sign(params, session);
	}
	
	public String sign(String session) {
		return SignUtils.sign(new HashMap<String, String>(), session);
	}
}
