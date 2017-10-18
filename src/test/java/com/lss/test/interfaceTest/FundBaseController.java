package com.lss.test.interfaceTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import com.lss.test.interfaceTest.AppUserLogin;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class FundBaseController {
	/**
	 * 基金首页信息
	 */
	@BeforeClass
	public void beforeClass() {

		RestAssured.baseURI = "http://shitouji.bluestonehk.com";
		AppUserLogin session = new AppUserLogin();
		String loginSession = session.session;
	}

	public void succFundBase() {
		AppUserLogin session = new AppUserLogin();
		String loginSession = session.session;
		given().log().all().param("QUARTZ-SESSION", loginSession);
	}

}
