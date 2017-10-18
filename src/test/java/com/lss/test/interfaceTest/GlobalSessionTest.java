package com.lss.test.interfaceTest;

import org.testng.annotations.BeforeClass;

public class GlobalSessionTest extends BaseTest {

	public String session;

	@BeforeClass
	public void before() {
		super.before();
		this.session = login("14700000030", "666666","86");
	}
	
	public String sign(Object params) {
		return super.sign(params, session);
	}
	
	public String sign() {
		return super.sign(session);
	}
}
