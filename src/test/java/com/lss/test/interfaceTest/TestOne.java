package com.lss.test.interfaceTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;
import io.restassured.RestAssured;


public class TestOne {
	
	@BeforeClass
	public  void  beforeClass() {
		//定义所有请求使用ssl配置，避免https安全证书问题
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI="https://xueqiu.com";
	}
	
	@Test
	public void loginDemo() {
		given()
			.log().all()
			.header("X-Requested-With","XMLHttpRequest")
			.formParam("username", "18665834251")
			.formParam("password", "666666")
		.when()
			.post("/snowman/login")
		.then()
			.log().all()
			.statusCode(200)
			.body("error_description",equalTo("用户名或密码错误"));		
					
	}
	
}
