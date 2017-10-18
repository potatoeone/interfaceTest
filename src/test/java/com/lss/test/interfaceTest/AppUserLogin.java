package com.lss.test.interfaceTest;



import org.apache.commons.codec.digest.DigestUtils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static org.hamcrest.Matchers.*; 
import static io.restassured.RestAssured.*;
import com.lss.test.interfaceTest.LoginParams;

/**
 * 登录接口
 */

public class AppUserLogin {
	public String session;
	
	@BeforeClass
	public void beforeClass() {
		RestAssured.baseURI="http://shitouji.bluestonehk.com";
	}

	@Test
	public void login() {
		//对密码进行加密
		String pwd ="666666";
		String md5Pwd=DigestUtils.md5Hex(pwd);
		LoginParams loginparam = new LoginParams();
		loginparam.password= md5Pwd;
		loginparam.user_name= "14700000030";
		loginparam.region_code = "86";
		
		Response response =		
		given()
			.log().all()
			.formParam("password",loginparam.password)
			.formParam("region_code",loginparam.region_code)
			.formParam("user_name",loginparam.user_name)
		.when()
			.post("/api/app/user/login")
		.then()
			.log().all()
			.statusCode(200)
			.body("errno", equalTo(0))
			.body("body.phone", equalTo(loginparam.user_name))
			.body("body.region_code", equalTo(loginparam.region_code))
			//.body("body.nick_name", nullValue())
			.body("message",equalTo("登录成功"))
			.extract()
			.response();
		
		//保存
	    session =response.path("body.session");
		System.out.println(session);
					
	}
	
	
	
	
}
